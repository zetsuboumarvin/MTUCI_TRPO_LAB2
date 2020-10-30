package com.mtuci.lab2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class RestController {

    @GetMapping("/hostname")
    public ResponseEntity<String> getHostname() throws UnknownHostException {
        return new ResponseEntity<>(InetAddress.getLocalHost().getHostName(), HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("I'M ALIVE!", HttpStatus.OK);
    }
}
