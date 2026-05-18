package io.github.carloscardoso05.bidflow.controller;

import io.github.carloscardoso05.bidflow.service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@NullMarked
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @SecurityRequirement(name = "basicAuth")
    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }
}
