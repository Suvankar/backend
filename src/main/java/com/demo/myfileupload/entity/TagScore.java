package com.demo.myfileupload.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class TagScore {
    private String tagname;
    private int tagscore;
    private int confidence;
}
