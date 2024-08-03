package com.wesleybertipaglia.securepass.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wesleybertipaglia.securepass.records.generator.PasswordGeneratorResponseDTO;
import com.wesleybertipaglia.securepass.services.PasswordGeneratorService;

public class PasswordGeneratorServiceTests {
    private PasswordGeneratorService passwordGeneratorService;

    @BeforeEach
    public void setUp() {
        passwordGeneratorService = new PasswordGeneratorService();
    }

    @Test
    public void testGeneratePasswordSuccess() {
        PasswordGeneratorResponseDTO passwordResponseDTO = passwordGeneratorService.generatePassword(10, true, true,
                true, true);

        assertEquals(passwordResponseDTO.properties().passwordLength(), 10);
        assertEquals(passwordResponseDTO.properties().includeUppercase(), true);
        assertEquals(passwordResponseDTO.properties().includeLowercase(), true);
        assertEquals(passwordResponseDTO.properties().includeNumbers(), true);
        assertEquals(passwordResponseDTO.properties().includeSpecial(), true);

        String password = passwordResponseDTO.password();

        assertEquals(password.length(), 10);
        assertEquals(password.chars().anyMatch(Character::isUpperCase), true);
        assertEquals(password.chars().anyMatch(Character::isLowerCase), true);
        assertEquals(password.chars().anyMatch(Character::isDigit), true);
        assertEquals(password.chars().anyMatch(c -> "!@#$%^&*()-_+=<>?".indexOf(c) >= 0), true);
    }

    @Test
    public void testGeneratePasswordFailure() {
        try {
            passwordGeneratorService.generatePassword(0, true, true, true, true);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Password length must be greater than zero");
        }

        try {
            passwordGeneratorService.generatePassword(10, false, false, false, false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "At least one character set must be selected");
        }
    }
}