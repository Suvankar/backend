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
@Table(name = "filesimilardocs", schema = "fileupload")
public class FileSimilarDocs implements Serializable {
    @Id
    public String uid;

    @ElementCollection
    List<SimilarDocumentLinks> similarDocumentLinks;

}
