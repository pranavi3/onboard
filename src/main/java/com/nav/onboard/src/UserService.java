package com.nav.onboard.src;

import com.nav.onboard.model.SignUpResponse;
import com.nav.onboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public SignUpResponse signup(User user){
        return userDao.signup(user);
    }

    public SignUpResponse login(User user){
        return userDao.login(user);
    }
}
