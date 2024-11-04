package lk.ijse.gdse.aad67.greenshadowbackendapi.dao;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleEntity,String> {
}
