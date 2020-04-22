package com.essential.gateway.service;

import com.essential.gateway.authenticator.User;

public interface LoginServiceInterface {
    String login(String username, String password);
    User saveUser(User user);

    boolean logout(String token);

    Boolean isValidToken(String token);

    String createNewToken(String token);
}
