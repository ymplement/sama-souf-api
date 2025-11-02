package com.samasouf.domain.params;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import com.samasouf.domain.User;

@Setter
@Getter
@Entity
@Table(name = "type_notification")
public class TypeNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_notification_id_seq")
    private Long ype_notification_id;

    @Column(name = "announcement")
    private boolean announcement;

    @Column(name = "price")
    private boolean price;

    @Column(name = "message")
    private boolean message;

    @Column(name = "visit")
    private boolean visit;

    @Column(name = "newsletter")
    private boolean newsletter;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
