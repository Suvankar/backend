package com.demo.myfileupload.controller;

import com.demo.myfileupload.entity.FileDetails;
import com.demo.myfileupload.entity.FileOtherDetails;
import com.demo.myfileupload.excpetion.NoFileFoundException;
import com.demo.myfileupload.model.FilesCountData;
import com.demo.myfileupload.repository.FileDetailsRepository;
import com.demo.myfileupload.repository.IFileOtherDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class FilesOtherDetailsController {
    @Autowired
    IFileOtherDetailsRepo otherDetailsRepo;


    @Autowired
    private FileDetailsRepository fileDetailsRepository;

    @PostMapping("/files/{uid}/details")
    public FileOtherDetails updateOtherDetails(@PathVariable String uid,
                                               @RequestBody FileOtherDetails request){
        System.out.println(request);
        return otherDetailsRepo.save(request);
    }

    @GetMapping("/files/{uid}/details")
    public FileOtherDetails fetchotherDetails(@PathVariable String uid) throws Exception{
        return otherDetailsRepo.findById(uid).orElseThrow(() ->new NoFileFoundException(""));
    }

    @GetMapping("/files/{uid}/information")
    public FileDetails fetchDetails(@PathVariable String uid) throws Exception{
        return fileDetailsRepository.findById(uid).orElseThrow(() ->new NoFileFoundException(""));
    }

    @GetMapping("/user/{userid}/files/counts")
    public FilesCountData fetchCountDetails(@PathVariable String userid) throws Exception{
        FilesCountData filesCountData = new FilesCountData();
        filesCountData.setTotalCount(fileDetailsRepository.count());
        filesCountData.setMyCount(otherDetailsRepo.countByUserId(userid));
        return filesCountData;
    }



}
