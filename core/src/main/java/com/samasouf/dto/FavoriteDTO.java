package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDTO {
    private Long favoriteId;
    private OffsetDateTime date;
    private AnnouncementDTO announcement;
    private UserDTO user;
}
