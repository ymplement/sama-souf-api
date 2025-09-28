package com.samasouf.domain;

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

@Setter
@Getter
@Entity
@Table(name = "transaction_land")
@Audited
public class TransactionLand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_land_id_seq")
    private Long transaction_land_id;

    @Column(name = "transaction_date")
    private String type; // reservation, sale, rent...

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private Double price;

    @Column(name = "commission")
    private Double commission;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_date")
    private OffsetDateTime paymentDate;

    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // payeur

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    private Announcement announcement;
}
