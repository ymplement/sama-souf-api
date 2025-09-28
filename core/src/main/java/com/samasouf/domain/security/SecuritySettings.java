package com.samasouf.domain.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Table(name = "security_settings")
@Audited
public class SecuritySettings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "security_settings_id_seq")
    private Long security_settings_id;

    @Column(name = "two_factor_enabled")
    private boolean twoFactorEnabled;

    @Column(name = "two_factor_method")
    private String twoFactorMethod;

    @Column(name = "two_factor_secret")
    private String twoFactorSecret;

    @Column(name = "ip_last_login")
    private String ipLastLogin;

    @Column(name = "user_agent")
    private String userAgent;
}
