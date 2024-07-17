package org.enrichment.talent_scouting_backend.services;

import org.enrichment.talent_scouting_backend.helper.AppException;
import org.enrichment.talent_scouting_backend.models.User;
import org.enrichment.talent_scouting_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    public User findByLogin(String login) {
        return userRepository.findByLoginStudent(login)
                .orElseThrow(() -> new AppException(HttpStatus.NOT_FOUND, "Unknown User"));
    }

    public User login(String login, char[] password) {
        User user = userRepository.findByLoginStudent(login)
                .orElseThrow(() -> new AppException(HttpStatus.NOT_FOUND, "Unknown User"));

        if (passwordEncoder.matches(CharBuffer.wrap(password), user.getPassword())) {
            return user;
        }
        throw  new AppException(HttpStatus.BAD_REQUEST, "Invalid Password");
    }


}
