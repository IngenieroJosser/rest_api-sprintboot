package rest_api.rest_api_sprintboot.repository;

import rest_api.rest_api_sprintboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
