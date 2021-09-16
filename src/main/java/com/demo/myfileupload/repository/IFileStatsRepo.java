package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileSimilarDocs;
import com.demo.myfileupload.entity.FileStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileStatsRepo extends JpaRepository<FileStats,String> {
}
