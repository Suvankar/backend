package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileAutoTags;
import com.demo.myfileupload.entity.FileFAQS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileFAQSRepo extends JpaRepository<FileFAQS,String> {
}
