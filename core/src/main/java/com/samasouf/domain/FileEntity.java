package com.samasouf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "file_store")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "file_entity_id_seq")
    private Long file_entity_id;

    @Column(name = "type")
    private String type; // doc, image, pdf...

    @Column(name = "url")
    private String url; // storage url

    @Column(name = "name")
    private String name;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "size")
    private String size; // ex: "2.1MB"

    @Column(name = "verified")
    private boolean verified;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}