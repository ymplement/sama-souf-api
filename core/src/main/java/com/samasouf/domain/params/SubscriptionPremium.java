package com.samasouf.domain.params;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import com.samasouf.domain.User;

@Setter
@Getter
@Entity
@Table(name = "subscription")
@Audited
public class SubscriptionPremium {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_id_seq")
    private Long subscription_id;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Column(name = "type")
    private String type;

    @Column(name = "statut")
    private String statut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}