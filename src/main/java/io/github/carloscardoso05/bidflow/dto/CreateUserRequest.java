package io.github.carloscardoso05.bidflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(
                @NotBlank @Email @Length(max = 50) String email,
                @NotBlank @Length(max = 80) String firstName,
                @NotBlank @Length(max = 80) String lastName,
                @NotBlank @Length(max = 255) String password) {
}
