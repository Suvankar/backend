package com.demo.myfileupload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filedetails", schema = "fileupload")
public class FileDetails implements Serializable {

    @Id
    public String uid;

    @Column(name = "filename")
    public String fileName;

    @Column(name = "filetype")
    public String fileType;

    @Column(name = "filedownloadurl")
    public String fileDownloadUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;



}
