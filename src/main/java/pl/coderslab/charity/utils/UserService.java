package pl.coderslab.charity.utils;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {


private final UserRepository userRepository;
private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public User addRoleToUser(User user){
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));

        return user;
    }


}
