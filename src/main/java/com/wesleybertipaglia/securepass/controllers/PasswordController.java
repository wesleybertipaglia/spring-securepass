package com.wesleybertipaglia.securepass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wesleybertipaglia.securepass.records.checker.PasswordCheckerRequestDTO;
import com.wesleybertipaglia.securepass.records.checker.PasswordCheckerResponseDTO;
import com.wesleybertipaglia.securepass.records.generator.PasswordGeneratorResponseDTO;
import com.wesleybertipaglia.securepass.services.PasswordCheckerService;
import com.wesleybertipaglia.securepass.services.PasswordGeneratorService;

@RestController
@RequestMapping("/passwords")
public class PasswordController {

    @Autowired
    private PasswordCheckerService passwordCheckerService;

    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @PostMapping("/check")
    public ResponseEntity<PasswordCheckerResponseDTO> checkPassword(
            @RequestBody PasswordCheckerRequestDTO passwordCheckerRequestDTO) {
        return ResponseEntity.ok(passwordCheckerService.checkPassword(passwordCheckerRequestDTO));
    }

    @PostMapping("/generate")
    public ResponseEntity<PasswordGeneratorResponseDTO> generatePassword(
            @RequestParam(defaultValue = "12") int passwordLength,
            @RequestParam(defaultValue = "true") boolean includeUppercase,
            @RequestParam(defaultValue = "true") boolean includeLowercase,
            @RequestParam(defaultValue = "true") boolean includeNumbers,
            @RequestParam(defaultValue = "true") boolean includeSpecial) {
        return ResponseEntity
                .ok(passwordGeneratorService.generatePassword(passwordLength, includeUppercase, includeLowercase,
                        includeNumbers, includeSpecial));
    }
}
