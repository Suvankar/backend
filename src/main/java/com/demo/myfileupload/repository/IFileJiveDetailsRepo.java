package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileFAQS;
import com.demo.myfileupload.entity.FileJiveDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileJiveDetailsRepo extends JpaRepository<FileJiveDetails,String> {
}
