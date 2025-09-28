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
import org.hibernate.envers.Audited;

import com.samasouf.domain.User;

@Setter
@Getter
@Entity
@Table(name = "notification_preference")
@Audited
public class NotificationPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_preference_id_seq")
    private Long notification_preference_id;

    @Column(name = "email")
    private boolean email;

    @Column(name = "sms")
    private boolean sms;

    @Column(name = "push")
    private boolean push;

    @Column(name = "marketing")
    private boolean marketing;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

}
