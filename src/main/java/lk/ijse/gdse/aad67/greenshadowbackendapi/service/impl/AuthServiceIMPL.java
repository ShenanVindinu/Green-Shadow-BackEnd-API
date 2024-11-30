package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.UserDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.UserDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.UserEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.UserNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.secure.JWTAuthResponse;
import lk.ijse.gdse.aad67.greenshadowbackendapi.secure.SignIn;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.AuthService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {

    private final UserDAO userDAO;
    private final Mapping mapping;
    private final JWTServiceIMPL jwtService;
//    private final AuthenticationManager authenticationManager;


    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        UserEntity savedUser = userDAO.save(mapping.toUserEntity(userDTO));
        //Generate the token and return it

        return JWTAuthResponse.builder().build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        return null;
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
