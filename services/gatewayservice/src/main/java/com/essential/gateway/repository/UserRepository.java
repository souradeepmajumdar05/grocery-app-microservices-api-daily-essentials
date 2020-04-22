package com.essential.gateway.repository;

import com.essential.gateway.authenticator.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    //@Query(value="{'email' : ?0}")
    List<User> findByEmail(String email);
}
