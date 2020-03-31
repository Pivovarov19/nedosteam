package com.pivovarov.nedosteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;

    User saveUser(User user) {
        return userRepository.save(user);
    }
}
