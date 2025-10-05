package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecuritySettingsDTO {
    private Long securitySettingsId;
    private boolean twoFactorEnabled;
    private String twoFactorMethod;
    private String twoFactorSecret;
    private String ipLastLogin;
    private String userAgent;
}
