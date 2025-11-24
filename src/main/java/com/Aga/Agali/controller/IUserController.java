package com.Aga.Agali.controller;

import com.Aga.Agali.dto.UserCreateDTO;
import com.Aga.Agali.dto.UserLoginDTO;
import com.Aga.Agali.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface IUserController {
    UserResponseDTO save(@Valid UserCreateDTO dto);

    UserResponseDTO getById(Long id);

    List<UserResponseDTO> getAll();

    UserResponseDTO updateUser(Long id,@Valid UserCreateDTO dto);

    void deleteUser(Long id);

    UserResponseDTO login(@Valid UserLoginDTO dto);
}
