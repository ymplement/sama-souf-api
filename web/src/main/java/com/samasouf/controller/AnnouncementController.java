package com.samasouf.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import com.samasouf.command.IAnnouncementListResponseCommand;
import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.response.AnnouncementListResponse;
import com.samasouf.request.AnnouncementRequest;
import com.samasouf.mapper.RequestMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@Validated
class AnnouncementController {

    private final IAnnouncementListResponseCommand announcementListResponseCommand;
    private final RequestMapper requestMapper;

    @PostMapping("/announcements")
    AnnouncementListResponse getAnnouncementsByCriteria(@Valid AnnouncementRequest request) {

        log.info("Getting announcements list - page: {}, size: {}", request.getPage(), request.getSize());

        AnnouncementCriteria criteria = requestMapper.toAnnouncementCriteria(request);
        return announcementListResponseCommand.execute(criteria);
    }
}