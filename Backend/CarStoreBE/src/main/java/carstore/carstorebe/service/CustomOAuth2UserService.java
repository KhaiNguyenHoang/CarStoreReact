package carstore.carstorebe.service;

import carstore.carstorebe.model.Users;
import carstore.carstorebe.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        OAuth2User oauth2User = super.loadUser(userRequest);
        String email = oauth2User.getAttribute("email");

        Optional<Users> userOptional = usersRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            Users user = new Users();
            user.setEmail(email);
            user.setFullName(oauth2User.getAttribute("name"));
            // Set other necessary fields from oauth2User
            usersRepository.save(user);
        }

        return oauth2User;
    }
}
