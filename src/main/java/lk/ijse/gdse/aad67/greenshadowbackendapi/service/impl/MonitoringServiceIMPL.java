package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.MonitoringLogDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.MonitoringLogService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
}
