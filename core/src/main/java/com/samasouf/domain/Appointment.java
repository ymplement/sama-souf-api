package com.samasouf.domain;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Setter
@Getter
@Entity
@Table(name = "appointment")
@Audited
public class Appointment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "appointment_id_seq")
    private Long appointment_id;

    @Column(name = "scheduled_date")
    private OffsetDateTime scheduledDate;

    @Column(name = "estimated_date")
    private OffsetDateTime estimatedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;

    @Column(name = "proof_of_visit")
    private String proofOfVisit;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user; // qui a pris le RDV

    @ManyToOne
    @JoinColumn(name = "announcement_id", referencedColumnName = "announcement_id")
    private Announcement announcement;
}