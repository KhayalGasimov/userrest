package com.company.service;


import com.company.entity.User;
import com.company.exception.RecordNotfoundException;
import com.company.repositories.UserRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
     List<User> usersList = (List<User>) repository.findAll();
     if(usersList.size()>0){
     return usersList;
      } else {
    return new ArrayList<User>();
}

}public User createOrUpdateUser(User entity) throws RecordNotfoundException
    {
        Optional<User> user = repository.findById((long) entity.getId());

        if(user.isPresent())
        {
            User newEntity = user.get();
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

    public void deleteById(long id) throws RecordNotfoundException
    {
        Optional<User> user = repository.findById(id);

        if(user.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotfoundException("No User record exist for given id");
        }
    }

        public User findById(long id) throws RecordNotfoundException
    {
        Optional<User> user = repository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotfoundException("No employee record exist for given id");
        }
    }
    }


