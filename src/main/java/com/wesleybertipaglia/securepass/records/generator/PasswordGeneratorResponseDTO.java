package com.wesleybertipaglia.securepass.records.generator;

public record PasswordGeneratorResponseDTO(String password, GenerationProperties properties) {

        public record GenerationProperties(
                        int passwordLength,
                        boolean includeUppercase,
                        boolean includeLowercase,
                        boolean includeNumbers,
                        boolean includeSpecial) {
        }
}
