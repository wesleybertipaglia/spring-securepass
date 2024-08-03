package com.wesleybertipaglia.securepass.records.auth;

import java.util.UUID;

public record AuthResponseDTO(UUID id, String name, String email) {
}