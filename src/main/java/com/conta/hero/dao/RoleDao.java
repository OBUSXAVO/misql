package com.conta.hero.dao;

import com.conta.hero.model.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
