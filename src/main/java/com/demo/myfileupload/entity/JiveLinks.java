package com.demo.myfileupload.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class JiveLinks {
    private String jivelink;
    private String confidence;
}
