package com.dio.jwt.service;

import com.dio.jwt.data.UserData;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    //inicializar o encrypt
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //construtor do encrypt
    public UserDetailServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //buscar usuario pelo nome
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData user = findUser(username);

        if(user == null) throw new UsernameNotFoundException(username);

        return new User(user.getUserName(), user.getPassword(), Collections.emptyList());

    }

    private UserData findUser(String username) {

        UserData user = new UserData();
        user.setUserName("admin");
        user.setPassword(bCryptPasswordEncoder.encode("paulo"));

        return user;
    }

    public List<UserData> listUser(){
        ArrayList<UserData> lst = new ArrayList<>();

        lst.add(findUser("admin"));
        return lst;
    }
}
