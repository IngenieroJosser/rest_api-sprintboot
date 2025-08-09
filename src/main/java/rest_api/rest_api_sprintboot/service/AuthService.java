package rest_api.rest_api_sprintboot.service;

import rest_api.rest_api_sprintboot.entity.Auth;
import rest_api.rest_api_sprintboot.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public List<Auth> getAllUserAuthenticated() {
        return authRepository.findAll();
    }

    // Registro: guardar usuario con password hasheado
    public Auth registerUser(Auth authUser) {
        // Hash de la contraseña antes de guardar
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUser.setIsActive(true);  // usuario activo por defecto
        return authRepository.save(authUser);
    }

    // Login: validar email y password
    public Auth loginUser(String email, String rawPassword) {
        Optional<Auth> findUser = authRepository.findByEmail(email);

        if (findUser.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Auth user = findUser.get();

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        if (user.getIsActive() == null || !user.getIsActive()) {
            throw new RuntimeException("Usuario no activo");
        }

        // Login exitoso, devolver usuario o generar token JWT
        return user;
    }
}