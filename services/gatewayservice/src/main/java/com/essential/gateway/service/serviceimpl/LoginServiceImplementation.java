package com.essential.gateway.service.serviceimpl;

import com.essential.gateway.authenticator.JwtToken;
import com.essential.gateway.authenticator.Role;
import com.essential.gateway.authenticator.User;
import com.essential.gateway.exception.CustomException;
import com.essential.gateway.repository.JwtTokenRepository;
import com.essential.gateway.repository.UserRepository;
import com.essential.gateway.security.JwtTokenProvider;
import com.essential.gateway.service.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LoginServiceImplementation implements LoginServiceInterface
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Override
    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    password));
            List<User> listOfuser = userRepository.findByEmail(username);
            if (listOfuser.size()<1|| listOfuser == null || listOfuser.get(0).getRole() == null || listOfuser.get(0).getRole().isEmpty()) {
                throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
            }
            User user =listOfuser.get(0);
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            String token =  jwtTokenProvider.createToken(username, user.getRole().stream()
                    .map((Role role)-> "ROLE_"+role.getRole()).filter(Objects::nonNull).collect(Collectors.toList()));
            return token;

        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        return userRepository.save(user);
    }

    @Override
    public boolean logout(String token) {
         jwtTokenRepository.delete(new JwtToken(token));
         return true;
    }

    @Override
    public Boolean isValidToken(String token) {
        System.out.println("token : " +token);
        return jwtTokenProvider.validateToken(token);
    }

    @Override
    public String createNewToken(String token) {
        String username = jwtTokenProvider.getUsername(token);
        List<String>roleList = jwtTokenProvider.getRoleList(token);
        String newToken =  jwtTokenProvider.createToken(username,roleList);
        return newToken;
    }
}
