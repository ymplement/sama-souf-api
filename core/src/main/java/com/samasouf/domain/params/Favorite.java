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

import com.samasouf.domain.Announcement;
import com.samasouf.domain.User;

@Setter
@Getter
@Entity
@Table(name = "favorite")
@Audited
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_id_seq")
    private Long favorite_id;

    @Column(name = "date")
    private OffsetDateTime date;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    private Announcement announcement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}