package lk.ijse.gdse.aad67.greenshadowbackendapi.service;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;

import java.util.List;

public interface MonitoringLogService {
    void saveLog(MonitoringLogDTO monitoringLogDTO);

    void deleteLog(String logId);

    List<MonitoringLogDTO> getAllLogs();

    void updateLog(String logId,MonitoringLogDTO monitoringLogDTO);
}
