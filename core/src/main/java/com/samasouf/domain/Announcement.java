package com.samasouf.domain;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import com.samasouf.domain.valueObject.AnnouncementStatus;

@Setter
@Getter
@Entity
@Table(name = "announcement")
@Audited
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "announcement_id_seq")
    private Long announcement_id;

    @Column(length = 255, name = "title")
    private String title;

    @Column(length = 4000, name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private AnnouncementStatus announcementTransaction;

    @Column(name = "startDate")
    private OffsetDateTime startDate;
    @Column(name = "endDate")
    private OffsetDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "external_source_id", referencedColumnName = "external_source_id")
    private ExternalSource externalSource;

    @OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Land> lands = new ArrayList<>();

}