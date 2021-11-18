package pl.coderslab.charity.utils;

import org.springframework.security.core.GrantedAuthority;
import pl.coderslab.charity.entity.User;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {


    private final User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> grantedAuthorities, User user){
        super(username, password, grantedAuthorities);
        this.user= user;
    }

    public User getUser(){
        return user;
    }


}
