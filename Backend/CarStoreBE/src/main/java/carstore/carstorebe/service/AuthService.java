package carstore.carstorebe.service;

import carstore.carstorebe.dto.LoginRequest;
import carstore.carstorebe.dto.RegisterRequest;
import carstore.carstorebe.exception.EmailAlreadyExistsException;
import carstore.carstorebe.model.User;
import carstore.carstorebe.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import carstore.carstorebe.dto.LoginResponse;
import carstore.carstorebe.model.RefreshToken;
import carstore.carstorebe.dto.RefreshTokenRequest;
import com.nimbusds.jose.JOSEException;

import java.util.Date;
import java.time.Instant;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository UserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    public AuthService(AuthenticationManager authenticationManager, UsersRepository UserRepository, PasswordEncoder passwordEncoder, JwtService jwtService, RefreshTokenService refreshTokenService) {
        this.authenticationManager = authenticationManager;
        this.UserRepository = UserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
    }

    public LoginResponse login(LoginRequest loginRequest) throws JOSEException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        User user = UserRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        String jwt = jwtService.generateToken(authentication);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
        return new LoginResponse(jwt, refreshToken.getToken());
    }

    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) throws JOSEException {
        RefreshToken refreshToken = refreshTokenService.findByToken(refreshTokenRequest.getRefreshToken())
                .orElseThrow(() -> new RuntimeException("Refresh token is not in database!"));

        refreshTokenService.verifyExpiration(refreshToken);

        User user = refreshToken.getUser();
        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token, refreshTokenRequest.getRefreshToken());
    }

    public User register(RegisterRequest registerRequest) {
        if (UserRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email Address already in use!");
        }

        User user = new User();
        user.setFullName(registerRequest.getFullName());
        user.setEmail(registerRequest.getEmail());
        user.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedAt(Date.from(Instant.now()).toInstant());
        user.setUpdatedAt(Date.from(Instant.now()).toInstant());
        user.setStatus("Active");
        User savedUser = UserRepository.save(user);
        return savedUser;
    }
}
