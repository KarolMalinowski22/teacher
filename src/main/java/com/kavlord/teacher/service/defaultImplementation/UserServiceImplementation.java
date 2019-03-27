package com.kavlord.teacher.service.defaultImplementation;

import com.kavlord.teacher.model.User;
import com.kavlord.teacher.model.dto.UserDto;
import com.kavlord.teacher.repository.UserRepository;
import com.kavlord.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<User> getAllUsersPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        int startItem = pageSize * pageNumber;
        List<User> all = userRepository.findAll();
        List<User> listForPage;
        if(startItem > all.size()){
            listForPage = Collections.EMPTY_LIST;
        }else{
            listForPage = all.subList(startItem, Math.min(startItem + pageSize, all.size()));
        }
        Page<User> page = new PageImpl<>(listForPage, PageRequest.of(pageNumber, pageSize), all.size());
        return page;
    }
    @Override
    public User register(UserDto userDto){
        if(emailExist(userDto.getEmail())){
            throw new IllegalArgumentException("Taki adres już istnieje w systemie.");
        }else if(usernameExists(userDto.getUsername())){
            throw new IllegalArgumentException("Taka nazwa już istnieje");
        }
        User newUser = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getEmail());
        newUser.getRoles().add("ROLE_USER");
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
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
