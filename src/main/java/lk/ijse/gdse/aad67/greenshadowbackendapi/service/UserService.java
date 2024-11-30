package lk.ijse.gdse.aad67.greenshadowbackendapi.service;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void updateUser(UserDTO buildUserDTO);
}
