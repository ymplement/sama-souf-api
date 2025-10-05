package com.samasouf.dto;

import com.samasouf.domain.valueObject.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfidentialityDTO {
    private Long confidentialityId;
    private Visibility visibility;
    private boolean email;
    private boolean tel;
    private boolean address;
    private boolean link;
    private boolean share;
}
