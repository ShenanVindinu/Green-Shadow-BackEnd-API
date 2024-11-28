package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.UserDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.UserNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceIMPL(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDAO.findByEmail(userName)
                        .orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }

}
