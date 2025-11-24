package com.Aga.Agali.services.impl;

import com.Aga.Agali.dto.*;
import com.Aga.Agali.entity.User;
import com.Aga.Agali.repository.IUserRepository;
import com.Aga.Agali.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


    @Override
    public UserResponseDTO save(UserCreateDTO dto) {
        User user=new User();
        BeanUtils.copyProperties(dto,user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        User saved=userRepository.save(user);
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        BeanUtils.copyProperties(saved,userResponseDTO);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponseDTO responseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, responseDTO);


        if (user.getInteractions() != null) {
            responseDTO.setInteractions(
                    user.getInteractions().stream().map(interaction -> {
                        UserInteractionResponseDTO uiDTO = new UserInteractionResponseDTO();
                        BeanUtils.copyProperties(interaction, uiDTO);
                        return uiDTO;
                    }).toList()
            );
        }


        if (user.getRecommendations() != null) {
            responseDTO.setRecommendations(
                    user.getRecommendations().stream().map(rec -> {
                        RecommendationResponseDTO recDTO = new RecommendationResponseDTO();
                        BeanUtils.copyProperties(rec, recDTO);
                        return recDTO;
                    }).toList()
            );
        }

        return responseDTO;
    }

    @Override
    public List<UserResponseDTO> getAll() {
        List<User>users=userRepository.findAll();
        List<UserResponseDTO>responseList=new ArrayList<>();
        for(User user:users) {
            UserResponseDTO dto=new UserResponseDTO();
            BeanUtils.copyProperties(user,dto);
            responseList.add(dto);

        }
        return responseList;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserCreateDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BeanUtils.copyProperties(dto, user, "password"); // password ayrı handled olunur

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }


        User updated = userRepository.save(user);


        UserResponseDTO responseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(updated, responseDTO);

        return responseDTO;
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);

    }

    @Override
    public UserResponseDTO login(UserLoginDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        UserResponseDTO responseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, responseDTO);

        return responseDTO;
    }
}
