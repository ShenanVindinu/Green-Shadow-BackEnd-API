package lk.ijse.gdse.aad67.greenshadowbackendapi.dao;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.MonitoringLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringLogDAO extends JpaRepository<MonitoringLogEntity,String> {

}
