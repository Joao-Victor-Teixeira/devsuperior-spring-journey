package com.joaodev.workshop_mongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.workshop_mongo.models.dto.UserDTO;
import com.joaodev.workshop_mongo.models.entities.User;
import com.joaodev.workshop_mongo.repositories.UserRepository;
import com.joaodev.workshop_mongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll(){
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public UserDTO findById(String id){
        Optional<User> result = repository.findById(id);
        User entity = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new UserDTO(entity);
    }

    public UserDTO insert(UserDTO dto){
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity = repository.insert(entity);
        return new UserDTO(entity);
    }


    public void copyDtoToEntity(UserDTO dto, User entity){

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}
