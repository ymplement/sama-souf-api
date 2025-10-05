package com.samasouf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samasouf.repository.LandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class SamaSoufApplication implements CommandLineRunner {

    private LandRepository landRepository;

    public static void main(String[] args) {
        SpringApplication.run(SamaSoufApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World " + landRepository.findAll().size());
    }

}
