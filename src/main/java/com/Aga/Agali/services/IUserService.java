package com.Aga.Agali.services;

import com.Aga.Agali.dto.UserCreateDTO;
import com.Aga.Agali.dto.UserLoginDTO;
import com.Aga.Agali.dto.UserResponseDTO;

import java.util.List;

public interface IUserService {
    UserResponseDTO save(UserCreateDTO dto);

    UserResponseDTO getById(Long id);

    List<UserResponseDTO> getAll();

    UserResponseDTO updateUser(Long id, UserCreateDTO dto);

    void deleteUser(Long id);

    UserResponseDTO login(UserLoginDTO dto);


}
