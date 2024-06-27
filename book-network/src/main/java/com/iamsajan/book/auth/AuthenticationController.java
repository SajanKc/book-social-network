package com.iamsajan.book.auth;

import com.iamsajan.book.auth.dto.AuthenticateRequest;
import com.iamsajan.book.auth.dto.AuthenticateResponse;
import com.iamsajan.book.auth.dto.RegistrationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "APIs for authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request) throws MessagingException {
        authenticationService.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> authenticate(
            @RequestBody @Valid AuthenticateRequest authenticateRequest) {

        return ResponseEntity.ok(authenticationService.authenticate(authenticateRequest));
    }

    @GetMapping("/activate-account")
    public void confirm(
            @RequestParam String token) throws MessagingException {
        authenticationService.activateAccount(token);
    }


}
