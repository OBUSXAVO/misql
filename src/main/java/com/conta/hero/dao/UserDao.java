package com.conta.hero.dao;

import com.conta.hero.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository <User, Long> {
    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);
}
