package com.samasouf.dto;

import com.samasouf.domain.common.Visibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfidentialityDTO {
    private Long confidentialityId;
    private Visibility visibility;
    private boolean email;
    private boolean tel;
    private boolean address;
    private boolean link;
    private boolean share;
}
