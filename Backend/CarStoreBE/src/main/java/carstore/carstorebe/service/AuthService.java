package carstore.carstorebe.service;

import carstore.carstorebe.dto.AuthResponse;
import carstore.carstorebe.dto.LoginRequest;
import carstore.carstorebe.dto.RegisterRequest;
import carstore.carstorebe.models.Users;
import carstore.carstorebe.repository.UsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, UsersRepository usersRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String registerUser(RegisterRequest registerRequest) {
        if (usersRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return "Username is already taken!";
        }

        Users user = new Users();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        // Set other user properties as needed

        usersRepository.save(user);

        return "User registered successfully!";
    }

    public AuthResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        String accessToken = jwtService.generateToken(authentication.getName());
        Users user = usersRepository.findByUsername(authentication.getName()).orElseThrow();
        String refreshToken = jwtService.generateRefreshToken(authentication.getName(), user.getId());
        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse refreshToken(String refreshToken) {
        if (jwtService.validateRefreshToken(refreshToken)) {
            String username = jwtService.extractUserName(refreshToken);
            Users user = usersRepository.findByUsername(username).orElseThrow();
            String newAccessToken = jwtService.generateToken(username);
            // Optionally, generate a new refresh token and revoke the old one
            // String newRefreshToken = jwtService.generateRefreshToken(username, user.getId());
            // jwtService.revokeRefreshToken(refreshToken);
            return new AuthResponse(newAccessToken, refreshToken);
        }
        return null; // Hoặc ném một ngoại lệ tùy chỉnh
    }
}
