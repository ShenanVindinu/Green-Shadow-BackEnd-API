package lk.ijse.gdse.aad67.greenshadowbackendapi.dao;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
