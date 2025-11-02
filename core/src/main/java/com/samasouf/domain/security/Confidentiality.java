package com.samasouf.domain.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.samasouf.domain.valueObject.Visibility;

@Getter
@Setter
@Entity
@Table(name = "confidentiality")
public class Confidentiality {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confidentiality_id_seq")
    private Long confidentiality_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "visibility")
    private Visibility visibility;

    @Column(name = "email")
    private boolean email;

    @Column(name = "tel")
    private boolean tel;

    @Column(name = "address")
    private boolean address;

    @Column(name = "link")
    private boolean link;

    @Column(name = "share")
    private boolean share;

}