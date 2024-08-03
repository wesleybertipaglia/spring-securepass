package com.wesleybertipaglia.securepass.PasswordChecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wesleybertipaglia.securepass.records.PasswordCheckerRequestDTO;
import com.wesleybertipaglia.securepass.records.PasswordCheckerResponseDTO;
import com.wesleybertipaglia.securepass.services.PasswordCheckerService;

public class PasswordCheckerServiceTests {
    private PasswordCheckerService passwordCheckerService;

    @BeforeEach
    public void setUp() {
        passwordCheckerService = new PasswordCheckerService();
    }

    @Test
    public void testCheckPasswordStrong() {
        PasswordCheckerRequestDTO passwordRequestDTO = new PasswordCheckerRequestDTO("Password123!");
        PasswordCheckerResponseDTO response = passwordCheckerService.checkPassword(passwordRequestDTO);

        assertEquals("Strong", response.strength());
        assertEquals(0, response.suggestions().size());
    }

    @Test
    public void testCheckPasswordMedium() {
        PasswordCheckerRequestDTO passwordRequestDTO = new PasswordCheckerRequestDTO("Password123");
        PasswordCheckerResponseDTO response = passwordCheckerService.checkPassword(passwordRequestDTO);

        assertEquals("Medium", response.strength());
        assertEquals(1, response.suggestions().size());
    }

    @Test
    public void testCheckPasswordWeak() {
        PasswordCheckerRequestDTO passwordRequestDTO = new PasswordCheckerRequestDTO("passwor");
        PasswordCheckerResponseDTO response = passwordCheckerService.checkPassword(passwordRequestDTO);

        assertEquals("Weak", response.strength());
        assertEquals(4, response.suggestions().size());
        assertEquals(response.suggestions().get(0), "Password must be at least 8 characters long");
        assertEquals(response.suggestions().get(1), "Password must contain at least one uppercase letter");
        assertEquals(response.suggestions().get(2), "Password must contain at least one number");
        assertEquals(response.suggestions().get(3),
                "Password must contain at least one special character (e.g. !@#$%^&*)");
    }
}
