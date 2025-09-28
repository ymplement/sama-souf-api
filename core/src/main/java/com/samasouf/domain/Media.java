package com.samasouf.domain;

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
@Table(name = "media")
@Audited
public class Media {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "media_id_seq")
    private Long media_id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type; // image, video

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

}
