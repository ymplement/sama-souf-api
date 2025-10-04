package com.samasouf.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Setter
@Getter
@Entity
@Table(name = "document")
@Audited
public class Document {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "document_id_seq")
    private Long document_id;

    @Column(length = 255, name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(length = 4000, name = "description")
    private String description;

    @Column(name = "verified")
    private boolean verified;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> files = new ArrayList<>();

}