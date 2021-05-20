package com.company.service;


import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.exception.RecordNotfoundException;
import com.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public User createOrUpdateUser(int id, User entity) throws RecordNotfoundException {
        Optional<User> userDTO = repository.findById(entity.getId());

        if (userDTO.isPresent()) {
            User newEntity = userDTO.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setName(entity.getName());
            newEntity.setSurname(entity.getSurname());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteById(long id) throws RecordNotfoundException {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotfoundException("No User record exist for given id");
        }
    }

    public User findById(long id) throws RecordNotfoundException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotfoundException("No employee record exist for given id");
        }
    }
}


