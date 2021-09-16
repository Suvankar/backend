package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileSimilarDocs;
import com.demo.myfileupload.entity.FileSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileSummaryRepo extends JpaRepository<FileSummaryEntity,String> {
}
