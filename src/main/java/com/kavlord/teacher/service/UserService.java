package com.kavlord.teacher.service;

import com.kavlord.teacher.model.User;
import com.kavlord.teacher.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
     Page<User> getAllUsersPaginated(Pageable pageable);
     User register(UserDto userDto);
}
