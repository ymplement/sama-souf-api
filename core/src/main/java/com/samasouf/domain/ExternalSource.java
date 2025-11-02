package com.samasouf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Setter
@Getter
@Entity
@Table(name = "external_source")
@Audited
public class ExternalSource {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "external_source_id_seq")
    private Long external_source_id;

    @Column(name = "name")
    private String name;

    @Column(name = "site_url")
    private String siteUrl;

    @Column(name = "type")
    private String type; // portal, gov, cadastre...
}