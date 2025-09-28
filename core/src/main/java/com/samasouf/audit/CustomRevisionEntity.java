package com.samasouf.audit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "revinfo")
@RevisionEntity
@Getter
@Setter
public class CustomRevisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @RevisionNumber
    private Long id;

    @RevisionTimestamp
    private LocalDateTime timestamp;

    private String username;
    private String ipAddress;
    private String userAgent;

    public CustomRevisionEntity() {
        this.timestamp = LocalDateTime.now();
    }
}
