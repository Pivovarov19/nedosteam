package com.pivovarov.nedosteam.service;


import com.pivovarov.nedosteam.repository.UserRepository;
import com.pivovarov.nedosteam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


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
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = null;
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        } else {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(login);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRole());
        }
        return userBuilder.build();
    }
}