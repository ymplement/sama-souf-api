package com.samasouf.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import com.samasouf.domain.chat.Message;
import com.samasouf.domain.params.Favorite;
import com.samasouf.domain.params.LandPreference;
import com.samasouf.domain.params.NotificationPreference;
import com.samasouf.domain.params.Search;
import com.samasouf.domain.params.SubscriptionPremium;
import com.samasouf.domain.params.TypeNotification;
import com.samasouf.domain.security.Confidentiality;
import com.samasouf.domain.security.Role;
import com.samasouf.domain.security.SecuritySettings;
import com.samasouf.domain.valueObject.AuthProvider;

@Setter
@Getter
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long user_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, name = "tel")
    private String tel;

    @Column(unique = true, name = "email")
    private String email;

    @Column(unique = true, name = "username")
    private String username;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
    private AuthProvider authProvider = AuthProvider.LOCAL;

    @Column(name = "provider_id", unique = true)
    private String providerId;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "language")
    private String language; // ou @Enumerated(Language) si tu préfères

    @Column(length = 2000, name = "bio")
    private String bio;

    @Column(name = "is_phone_verified")
    private boolean isPhoneVerified;

    @Column(name = "is_email_verified")
    private boolean isEmailVerified;

    @Column(name = "is_active")
    private boolean isActive;

    // Relations
    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "security_settings_id", referencedColumnName = "security_settings_id")
    private SecuritySettings securitySettings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "confidentiality_id", referencedColumnName = "confidentiality_id")
    private Confidentiality confidentiality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    // Préférences (1-1 naturelles)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private NotificationPreference notificationPreference;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LandPreference landPreference;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private TypeNotification typeNotification;

    // Historique / collections
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubscriptionPremium> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Search> searches = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites = new ArrayList<>();

    // Annonces, RDV, paiements, messages
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Announcement> announcements = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionLand> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages = new ArrayList<>();

}
