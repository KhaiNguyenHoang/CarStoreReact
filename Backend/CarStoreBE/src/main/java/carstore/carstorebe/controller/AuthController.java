package carstore.carstorebe.controller;

import carstore.carstorebe.dto.AuthResponse;
import carstore.carstorebe.dto.LoginRequest;
import carstore.carstorebe.dto.RegisterRequest;
import carstore.carstorebe.dto.RefreshTokenRequest;
import carstore.carstorebe.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        String result = authService.registerUser(registerRequest);
        if (result.equals("Username is already taken!")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        AuthResponse authResponse = authService.refreshToken(refreshTokenRequest.getRefreshToken());
        if (authResponse == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(authResponse);
    }
}
