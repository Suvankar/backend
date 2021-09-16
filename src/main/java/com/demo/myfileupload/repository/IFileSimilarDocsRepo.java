package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileOtherDetails;
import com.demo.myfileupload.entity.FileSimilarDocs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileSimilarDocsRepo extends JpaRepository<FileSimilarDocs,String> {
}
