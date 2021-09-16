package com.demo.myfileupload.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@Data
public class MyFilePathConfiguration {

    private final Path root;


    public MyFilePathConfiguration(@Value("${fileUpload.directory}") String directory){
        this.root = Paths.get(directory);;
    }
}
