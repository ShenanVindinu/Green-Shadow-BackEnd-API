package lk.ijse.gdse.aad67.greenshadowbackendapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserServiceEntity {

    @Id
    private String email;
    private String password;
    private Enum role;

}
