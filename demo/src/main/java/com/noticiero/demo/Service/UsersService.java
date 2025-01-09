package com.noticiero.demo.Service;

import com.noticiero.demo.DTOS.UserRequestDTO;
import com.noticiero.demo.DTOS.UserResponseDTO;
import com.noticiero.demo.Models.Users;
import com.noticiero.demo.Repository.UsersRepository;
import com.noticiero.demo.Util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private JwtUtils jwtUtils;

    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private UserResponseDTO UserDTOaUser(Users user) {
        UserResponseDTO userDTOa = new UserResponseDTO();
        userDTOa.setId(user.getId());
        userDTOa.setUsernanme(user.getUsername());
        userDTOa.setEmail(user.getEmail());
        userDTOa.setPassword(user.getPassword());
        return userDTOa;
    }

    public String createUser(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));

        usersRepository.save(user);

        String token = jwtUtils.genereteAccesToken(userRequestDTO.getUsername());

        return token;
    }

    public UserResponseDTO getUserByEmail(String email) {
        Users user = usersRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        return this.UserDTOaUser(user);
    }


    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND USER"));
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        user = usersRepository.save(user);

        return this.UserDTOaUser(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
