package com.wesleybertipaglia.securepass.records;

import java.util.List;

public record PasswordCheckerResponseDTO(String password, String strength, List<String> suggestions) {
}