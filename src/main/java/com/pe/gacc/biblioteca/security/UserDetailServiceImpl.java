package com.pe.gacc.biblioteca.security;

import com.pe.gacc.biblioteca.entity.User;
import com.pe.gacc.biblioteca.persistence.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("El usuario con email" + email + "no existe."));

        return new UserDetailsImpl(user);
    }
}
