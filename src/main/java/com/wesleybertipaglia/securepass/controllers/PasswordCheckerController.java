package com.wesleybertipaglia.securepass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleybertipaglia.securepass.records.PasswordCheckerRequestDTO;
import com.wesleybertipaglia.securepass.records.PasswordCheckerResponseDTO;
import com.wesleybertipaglia.securepass.services.PasswordCheckerService;

@RestController
@RequestMapping("/passwords")
public class PasswordCheckerController {

    @Autowired
    private PasswordCheckerService passwordCheckerService;

    @PostMapping("/check")
    public ResponseEntity<PasswordCheckerResponseDTO> checkPassword(@RequestBody PasswordCheckerRequestDTO password) {
        return ResponseEntity.ok(passwordCheckerService.checkPassword(password));
    }
}
