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
@Table(name = "immersive_view")
@Audited
public class ImmersiveView {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "immersive_view_id_seq")
    private Long immersive_view_id;

    @Column(name = "type")
    private String type; // 3D, streetview...

    @Column(name = "url")
    private String url;

    @Column(name = "vr_compatible")
    private boolean vrCompatible;

    @Column(name = "premium_only")
    private boolean premiumOnly;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

}
