package rest_api.rest_api_sprintboot.controller;

import rest_api.rest_api_sprintboot.entity.Auth;
import rest_api.rest_api_sprintboot.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public List<Auth> getAllUserAuthenticated() {
        return authService.getAllUserAuthenticated();
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Auth signUpUser(@Valid @RequestBody Auth dataUser) {
        return authService.registerUser(dataUser);
    }

    @PostMapping("/sign-in")
    public Auth signInUser(@Valid @RequestBody String email, String password) {
        return authService.loginUser(email, password);
    }
}
