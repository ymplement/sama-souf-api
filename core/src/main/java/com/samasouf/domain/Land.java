package com.samasouf.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Setter
@Getter
@Entity
@Table(name = "land")
@Audited
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "land_id_seq")
    private Long land_id;

    @Column(name = "title")
    private String title;

    @Column(length = 4000, name = "description")
    private String description;

    @Column(name = "surface")
    private Double surface;

    @Column(name = "price")
    private Double price;

    @Column(name = "type")
    private String type;

    @Column(name = "is_certified")
    private boolean isCertified;

    @Lob
    @Column(columnDefinition = "JSON", name = "commodity_json")
    private String commodityJson; // JSON brut (ou @JdbcType(Json) si tu utilises Hibernate Types)

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    private Announcement announcement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    // médias
    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> media = new ArrayList<>();

    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImmersiveView> immersiveViews = new ArrayList<>();

    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionLand> transactionLands = new ArrayList<>();

    @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

}
