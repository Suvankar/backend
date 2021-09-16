package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileAutoTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileAutoTagsRepo extends JpaRepository<FileAutoTags,String> {
}
