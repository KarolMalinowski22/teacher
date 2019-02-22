package com.kavlord.teacher.service;

import com.kavlord.teacher.model.User;
import com.kavlord.teacher.model.dto.UserDto;
import com.kavlord.teacher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public User register(UserDto userDto){
        if(emailExist(userDto.getEmail())){
            throw new IllegalArgumentException("Taki adres już istnieje w systemie.");
        }else if(usernameExists(userDto.getUsername())){
            throw new IllegalArgumentException("Taka nazwa już istnieje");
        }
        User newUser = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getEmail());
        newUser.getRoles().add("USER_ROLE");
        return userRepository.save(newUser);
    }

    private boolean usernameExists(String username) {
        Optional<User> byLogin = userRepository.findByLogin(username);
        return byLogin.isPresent();
    }

    private boolean emailExist(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        return byEmail.isPresent();
    }
}
