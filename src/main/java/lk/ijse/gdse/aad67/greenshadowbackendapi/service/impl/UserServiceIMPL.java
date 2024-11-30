package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.UserDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.UserDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.UserEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.UserNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.UserService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    private final UserDAO userDAO;
    private final Mapping mapping;

    @Autowired
    public UserServiceIMPL(UserDAO userDAO, Mapping mapping) {
        this.userDAO = userDAO;
        this.mapping = mapping;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDAO.findByEmail(userName)
                        .orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }

    @Override
    public void updateUser(UserDTO updatedUserDTO) {
        Optional<UserEntity> existingUserOptional = userDAO.findById(updatedUserDTO.getEmail());

        if (existingUserOptional.isPresent()) {
            UserEntity existingUser = existingUserOptional.get();

            mapping.asUserEntity(updatedUserDTO, existingUser);

            userDAO.save(existingUser);
        } else {
            throw new UserNotFoundException("User with email " + updatedUserDTO.getEmail() + " not found.");
        }
    }

}
