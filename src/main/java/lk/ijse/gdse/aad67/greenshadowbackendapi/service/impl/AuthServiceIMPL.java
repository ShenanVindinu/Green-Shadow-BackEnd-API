package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.UserDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.secure.JWTAuthResponse;
import lk.ijse.gdse.aad67.greenshadowbackendapi.secure.SignIn;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceIMPL implements AuthService {
    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        return null;
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        return null;
    }
}
