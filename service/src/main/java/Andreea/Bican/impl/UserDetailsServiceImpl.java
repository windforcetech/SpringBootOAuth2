package Andreea.Bican.impl;

import Andreea.Bican.AuthenticatedUser;
import Andreea.Bican.User;
import Andreea.Bican.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
<<<<<<< HEAD
 * Created by andre on 10.08.2016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUser(email);
        UserDetails userDetails = new AuthenticatedUser(user);

        if(user != null){
            return userDetails;
        }else{
            return null;
        }
    }
}
