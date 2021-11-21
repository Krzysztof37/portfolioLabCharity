package pl.coderslab.charity.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);


}
