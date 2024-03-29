package pl.coderslab.charity.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
