package com.Aga.Agali.controller.impl;

import com.Aga.Agali.controller.IUserInteractionController;
import com.Aga.Agali.dto.UserInteractionCreateDTO;
import com.Aga.Agali.dto.UserInteractionResponseDTO;
import com.Aga.Agali.services.IUserInteractionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/interactions")

public class UserInteractionControllerIMPL implements IUserInteractionController {
    @Autowired
    private IUserInteractionService userInteractionService;

    @Override
    @PostMapping
    public UserInteractionResponseDTO create(@RequestBody  UserInteractionCreateDTO dto) {
        return userInteractionService.create(dto);
    }

    @Override
    @GetMapping("/{id}")
    public UserInteractionResponseDTO getById(@PathVariable(name = "id") Long id) {
        return userInteractionService.getById(id);
    }

    @Override
    @GetMapping
    public List<UserInteractionResponseDTO> getAll() {
        return userInteractionService.getAll() ;
    }

    @Override
    @GetMapping("/user/{userId}")
    public List<UserInteractionResponseDTO> getByUserId(@PathVariable(name = "userId") Long userId) {
        return userInteractionService.getByUserId(userId);
    }

    @Override
    @GetMapping("/property/{propertyID}")
    public List<UserInteractionResponseDTO> getByPropertyId(@PathVariable(name = "propertyId") Long propertyId) {
        return userInteractionService.getByPropertyId(propertyId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userInteractionService.delete(id);

    }
}
