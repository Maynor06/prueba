package com.noticiero.demo.Service;

import com.noticiero.demo.DTOS.UserRequestDTO;
import com.noticiero.demo.DTOS.UserResponseDTO;
import com.noticiero.demo.Models.Users;
import com.noticiero.demo.Repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private UserResponseDTO UserDTOaUser(Users user) {
        UserResponseDTO userDTOa = new UserResponseDTO();
        userDTOa.setId(user.getId());
        userDTOa.setUsernanme(user.getUsername());
        userDTOa.setEmail(user.getEmail());
        userDTOa.setPassword(user.getPassword());
        return userDTOa;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        Users user = new Users();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        //creacion del usuario
        user = usersRepository.save(user);

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
