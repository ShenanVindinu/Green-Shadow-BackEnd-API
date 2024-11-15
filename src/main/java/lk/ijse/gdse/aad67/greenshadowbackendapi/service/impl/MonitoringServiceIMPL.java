package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.MonitoringLogDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.CropEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.MonitoringLogEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.MonitoringLogService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MonitoringServiceIMPL implements MonitoringLogService {

    private final MonitoringLogDAO monitoringLogDAO;
    private final Mapping mapping;
    private static final Logger logger = LoggerFactory.getLogger(MonitoringServiceIMPL.class);

    @Autowired
    public MonitoringServiceIMPL(MonitoringLogDAO monitoringLogDAO, Mapping mapping) {
        this.monitoringLogDAO = monitoringLogDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveLog(MonitoringLogDTO monitoringLogDTO) {
        logger.info(monitoringLogDTO.toString());
        monitoringLogDAO.save(mapping.toMonitoringLogEntity(monitoringLogDTO));
    }

    @Override
    public void deleteLog(String logId) {
        Optional<MonitoringLogEntity> monitoringLogEntity = monitoringLogDAO.findById(logId);
        if (monitoringLogEntity.isPresent()) {
            monitoringLogDAO.deleteById(logId);
        } else {
            logger.warn("Log with id {} not found", logId);
            throw new RuntimeException("Log with id " + logId + " not found");
        }
    }

    @Override
    public List<MonitoringLogDTO> getAllLogs() {
        return mapping.asMonitoringLogDTOList(monitoringLogDAO.findAll());
    }

    @Override
    public void updateLog(String logId, MonitoringLogDTO monitoringLogDTO) {
        Optional<MonitoringLogEntity> monitoringLogEntity = monitoringLogDAO.findById(logId);
        if (monitoringLogEntity.isPresent()) {
            MonitoringLogEntity newMlog = mapping.toMonitoringLogEntity(monitoringLogDTO);
            monitoringLogDAO.save(newMlog);
        } else {
            logger.warn("Log with id {} not found", logId);
            throw new RuntimeException("Log with id " + logId + " not found");
        }
    }
}
