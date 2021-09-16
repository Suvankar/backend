package com.demo.myfileupload.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class SimilarDocumentLinks {
    private String similarDocUid;
    private String similarDocName;
    private String confidence;
}
