package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import com.samasouf.domain.valueObject.AuthProvider;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String tel;
    private String email;
    private String username;
    private String password;
    private AuthProvider authProvider;
    private String providerId;
    private String avatarUrl;
    private String language;
    private String bio;
    private boolean isPhoneVerified;
    private boolean isEmailVerified;
    private boolean isActive;
    private Set<RoleDTO> roles;
    private Long securitySettingsId;
    private Long confidentialityId;
    private Long addressId;
    private Long notificationPreferenceId;
    private Long landPreferenceId;
    private Long typeNotificationId;
}
