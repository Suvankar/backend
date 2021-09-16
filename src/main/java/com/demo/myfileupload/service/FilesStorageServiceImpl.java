package com.demo.myfileupload.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import com.demo.myfileupload.entity.FileDetails;
import com.demo.myfileupload.repository.FileDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

    @Autowired
    private MyFilePathConfiguration configuration;

    @Autowired
    private FileDetailsRepository fileDetailsRepository;

    @Override
    public void init() {
        try {
            Files.createDirectory(configuration.getRoot());
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public FileDetails save(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        Optional<String> fileName = getExtensionByStringHandling(file.getOriginalFilename());
        String fileNameId = uuid.toString().substring(0,8);
        StringBuilder fileNameUuid = new StringBuilder(fileNameId);
        fileName.ifPresent(s -> fileNameUuid.append(".").append(s));
        try {
            Files.copy(file.getInputStream(), this.configuration.getRoot().resolve(fileNameUuid.toString()));
            FileDetails fileDetails = new FileDetails();
            fileDetails.setUid(fileNameId);
            fileDetails.setCreatedOn(new Date());
            fileDetails.setFileDownloadUrl("/files/"+fileNameUuid.toString());
            fileDetails.setFileName(file.getOriginalFilename());
            fileDetails.setFileType(fileName.orElse(""));

            fileDetailsRepository.save(fileDetails);
            return fileDetails;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
    @Override
    public Resource load(String filename) {
        try {
            Path file = configuration.getRoot().resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(configuration.getRoot().toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.configuration.getRoot(), 1).filter(path -> !path.equals(this.configuration.getRoot())).map(this.configuration.getRoot()::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}