package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String email;
    private String password;
    private Role role;

}
