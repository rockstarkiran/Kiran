package com.tutorialq.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentRefData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCUMENT_REF_ID", unique = true, nullable = false)
    private long documentRefDataId;
    private String cdeSection;
    private String sectionDisplayName;
    private String DscExplanation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<DocumentUpload> documentUploads = new HashSet<>(0);

    //Audit Information
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateCreated;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateLastModified;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateApproved;
    private String nameCreated;
    private String nameLastModified;
    private String nameApproved;


}