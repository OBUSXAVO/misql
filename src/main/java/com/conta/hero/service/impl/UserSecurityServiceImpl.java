package com.conta.hero.service.impl;


import com.conta.hero.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.conta.hero.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Le on 4/27/2016.
 */

@Service
public class UserSecurityServiceImpl implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityServiceImpl.class);

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (null == user) {
            LOG.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return user;
    }
}
