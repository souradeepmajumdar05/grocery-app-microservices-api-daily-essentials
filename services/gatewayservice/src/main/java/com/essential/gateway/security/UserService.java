package com.essential.gateway.security;

import com.essential.gateway.authenticator.MongoUserDetails;
import com.essential.gateway.authenticator.Role;
import com.essential.gateway.authenticator.User;
import com.essential.gateway.exception.CustomException;
import com.essential.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("email :"+email);
        List<User> listOfuser = userRepository.findByEmail(email);

        if (listOfuser.size()<1|| listOfuser == null || listOfuser.get(0).getRole() == null || listOfuser.get(0).getRole().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        User user = listOfuser.get(0);
        String [] authorities = new String[user.getRole().size()];
        int count=0;
        for (Role role : user.getRole()) {
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            authorities[count] = "ROLE_"+role.getRole();
            count++;
        }
        MongoUserDetails userDetails = new MongoUserDetails(user.getEmail(),user.getPassword(),user.getActive(),
                user.isLoacked(), user.isExpired(),user.isEnabled(),authorities);
        return userDetails;
    }



}
