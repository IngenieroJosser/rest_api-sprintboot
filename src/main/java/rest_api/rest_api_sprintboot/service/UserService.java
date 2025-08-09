package rest_api.rest_api_sprintboot.service;

import rest_api.rest_api_sprintboot.entity.User;
import rest_api.rest_api_sprintboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> findUserById = userRepository.findById(id);

        // If user not found, throw exception
        if (!findUserById.isPresent()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Return the User object
        return findUserById.get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = findUserById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return userRepository.save(existing);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}