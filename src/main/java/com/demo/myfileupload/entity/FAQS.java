package com.demo.myfileupload.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class FAQS {
    private String faq;
    private String confidence;
}
