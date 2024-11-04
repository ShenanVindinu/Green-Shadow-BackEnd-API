package lk.ijse.gdse.aad67.greenshadowbackendapi.dao;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.CropEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDAO extends JpaRepository<CropEntity,String> {
}
