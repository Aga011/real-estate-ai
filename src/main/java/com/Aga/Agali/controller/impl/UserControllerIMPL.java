package com.Aga.Agali.controller.impl;

import com.Aga.Agali.controller.IUserController;
import com.Aga.Agali.dto.UserCreateDTO;
import com.Aga.Agali.dto.UserLoginDTO;
import com.Aga.Agali.dto.UserResponseDTO;
import com.Aga.Agali.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/users")

public class UserControllerIMPL implements IUserController {
    @Autowired
    private IUserService userService;

    @Override
    @PostMapping
    public UserResponseDTO save(@RequestBody UserCreateDTO dto) {
        return userService.save(dto);
    }

    @Override
    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody  UserLoginDTO dto) {
        return userService.login(dto);
    }

    @Override
    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable(name = "id") Long id) {
        return userService.getById(id);
    }

    @Override
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAll();
    }

    @Override
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable(name = "id") Long id,@RequestBody  UserCreateDTO dto) {
        return userService.updateUser(id,dto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);

    }

}
