package com.uexcel.registerloginapp.service;


import com.uexcel.registerloginapp.entity.dto.UserDto;
import com.uexcel.registerloginapp.entity.User;
import com.uexcel.registerloginapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;

    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword1()));
        user.setRole("USER");
        userRepository.save(user);
    }
}
