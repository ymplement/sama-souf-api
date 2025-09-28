package com.samasouf.domain.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Table(name = "permission")
@Audited
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_id_seq")
    private Long permission_id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}