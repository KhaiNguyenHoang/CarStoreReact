package carstore.carstorebe.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String jwtKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    private SecretKeySpec secretKeySpec;

    @PostConstruct
    public void init() {
        this.secretKeySpec = new SecretKeySpec(jwtKey.getBytes(), "HmacSHA256");
    }

    public String generateToken(Authentication authentication) throws JOSEException {
        String authorities = authentication.getAuthorities().stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(authentication.getName())
                .claim("scope", authorities)
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + jwtExpiration))
                .build();

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                claimsSet);

        signedJWT.sign(new MACSigner(secretKeySpec));
        return signedJWT.serialize();
    }

    public String generateToken(String username) throws JOSEException {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .claim("scope", "ROLE_USER")
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + jwtExpiration))
                .build();

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                claimsSet);

        signedJWT.sign(new MACSigner(secretKeySpec));
        return signedJWT.serialize();
    }
}
