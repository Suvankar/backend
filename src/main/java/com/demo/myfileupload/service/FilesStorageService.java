package com.demo.myfileupload.service;

import com.demo.myfileupload.entity.FileDetails;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;

public interface FilesStorageService {
    public void init();

    public FileDetails save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
