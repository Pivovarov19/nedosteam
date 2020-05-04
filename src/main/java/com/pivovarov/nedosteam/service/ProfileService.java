package com.pivovarov.nedosteam.service;


import com.pivovarov.nedosteam.repository.UserRepository;
import com.pivovarov.nedosteam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;


    public User getUser(long id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new Exception("User isn't exist!");
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
