package rest_api.rest_api_sprintboot.repository;

import rest_api.rest_api_sprintboot.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthRepository  extends JpaRepository<Auth, Integer> {
    Optional<Auth> findByEmail(String email);
}
