package com.samasouf.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.samasouf.command.IAnnouncementListResponseCommand;
import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.response.AnnouncementListResponse;
import com.samasouf.request.AnnouncementRequest;

import jakarta.validation.Valid;

import com.samasouf.mapper.RequestMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("/announcements")
@RestController
class AnnouncementController {

    private final IAnnouncementListResponseCommand announcementListResponseCommand;
    private final RequestMapper requestMapper;

    @PostMapping
    AnnouncementListResponse getAnnouncementsByCriteria(@RequestBody @Valid AnnouncementRequest request) {

        log.info("Getting announcements list - page: {}, size: {}", request.getPage(), request.getSize());

        AnnouncementCriteria criteria = requestMapper.toAnnouncementCriteria(request);
        return announcementListResponseCommand.execute(criteria);
    }
}