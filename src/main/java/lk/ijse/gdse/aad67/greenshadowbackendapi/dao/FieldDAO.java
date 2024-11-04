package lk.ijse.gdse.aad67.greenshadowbackendapi.dao;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDAO extends JpaRepository<FieldEntity, Integer> {
}
