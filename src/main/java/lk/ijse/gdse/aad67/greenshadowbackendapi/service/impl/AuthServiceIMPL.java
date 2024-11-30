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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {

    private final UserDAO userDAO;
    private final Mapping mapping;
    private final JWTServiceIMPL jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword())
                );

        var user = userDAO.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        UserEntity savedUser = userDAO.save(mapping.toUserEntity(userDTO));

        var generatedToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {

        var userName = jwtService.extractUserName(accessToken);

        var findUser = userDAO.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(findUser);

        return JWTAuthResponse.builder().token(refreshToken).build();
    }

}
