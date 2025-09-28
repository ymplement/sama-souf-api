package com.samasouf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.samasouf.service.MyUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class SamaSoufController {

    private static final Logger log = LoggerFactory.getLogger(SamaSoufController.class);
    private final MyUserService myUserService;

    @GetMapping("/user/{userId}")
    String userName(@PathVariable("userId") String userId) {
        log.info("Got a request");
        return myUserService.userName(userId);
    }
}