package com.demo.myfileupload.repository;

import com.demo.myfileupload.entity.FileOtherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileOtherDetailsRepo extends JpaRepository<FileOtherDetails,String> {
    @Query("select count(*) from FileOtherDetails ex where ex.uploadedById = ?1 ")
    long countByUserId(String userId);
}
