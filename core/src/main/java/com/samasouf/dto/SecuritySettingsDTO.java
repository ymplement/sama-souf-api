package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecuritySettingsDTO {
    private Long securitySettingsId;
    private boolean twoFactorEnabled;
    private String twoFactorMethod;
    private String twoFactorSecret;
    private String ipLastLogin;
    private String userAgent;
}
