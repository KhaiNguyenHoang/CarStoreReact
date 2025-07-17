package carstore.carstorebe.service;

import carstore.carstorebe.models.Users;
import carstore.carstorebe.repository.UsersRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UsersRepository usersRepository;

    public CustomOAuth2UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String provider = userRequest.getClientRegistration().getRegistrationId(); // e.g., "google"
        String oauthId = oAuth2User.getName(); // This is typically the user's ID from the OAuth2 provider

        Optional<Users> userOptional = usersRepository.findByEmail(email);
        Users user;

        if (userOptional.isEmpty()) {
            // New user, register them
            user = new Users();
            user.setEmail(email);
            user.setUsername(name); // Or generate a unique username
            user.setOauthId(oauthId);
            user.setProvider(provider);
            // Set other default properties if needed
            usersRepository.save(user);
        } else {
            // Existing user, update their info if necessary
            user = userOptional.get();
            user.setOauthId(oauthId);
            user.setProvider(provider);
            usersRepository.save(user);
        }

        return oAuth2User;
    }
}
