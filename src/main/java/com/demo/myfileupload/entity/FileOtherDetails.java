package com.demo.myfileupload.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fileotherdetails", schema = "fileupload")
public class FileOtherDetails implements Serializable {
    @Id
    public String uid;

    @Column(name = "filename")
    public String fileName;

    @Column(name = "uploadedby")
    public String uploadedBy;

    @Column(name = "uploadedbyid")
    public String uploadedById;

    @Column(name = "ispiidata")
    public boolean isPiData;

    @Column(name = "uploadedbyimageurl")
    public String uploadedByImageUrl;



    @ElementCollection
    @CollectionTable(name = "customtags", joinColumns = @JoinColumn(name = "uid")) // 2
    @Column(name = "ctags") // 3
    private List<String> customTags;



}
