package com.samasouf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samasouf.criteria.LandCriteria;
import com.samasouf.dto.LandDTO;
import com.samasouf.dto.response.LandListResponse;
import com.samasouf.request.LandRequest;
import com.samasouf.command.ILandListCommand;
import com.samasouf.command.ILandGetByIdCommand;
import com.samasouf.mapper.RequestMapper;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RequestMapping("/lands")
@RestController
public class LandController {

    private final ILandListCommand landListCommand;
    private final ILandGetByIdCommand landGetByIdCommand;
    private final RequestMapper requestMapper;

    @PostMapping
    public ResponseEntity<LandListResponse> getLandsByCriteria(@RequestBody @Valid LandRequest request) {
        log.info("Getting lands list - page: {}, size: {}", request.getPage(), request.getSize());

        LandCriteria criteria = requestMapper.toLandCriteria(request);
        LandListResponse response = landListCommand.execute(criteria);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LandDTO> getLandById(@PathVariable Long id) {
        log.info("Getting land by id: {}", id);

        Optional<LandDTO> land = landGetByIdCommand.execute(id);

        return land.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
