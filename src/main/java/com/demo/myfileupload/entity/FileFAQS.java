package com.demo.myfileupload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filefaqs", schema = "fileupload")
public class FileFAQS implements Serializable {
    @Id
    public String uid;
    
    @ElementCollection
    List<FAQS> faqs;

}
