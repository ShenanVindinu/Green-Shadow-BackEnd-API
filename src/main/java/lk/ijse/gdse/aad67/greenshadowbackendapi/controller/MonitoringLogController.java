package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.LogNotFound;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.MonitoringLogNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.MonitoringLogService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/Mlog")
public class MonitoringLogController {

    private final MonitoringLogService monitoringLogService;

    private static final Logger logger = LoggerFactory.getLogger(MonitoringLogController.class);

    @Autowired
    public MonitoringLogController(MonitoringLogService monitoringLogService) {
        this.monitoringLogService = monitoringLogService;
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog( @RequestPart("logDate") String logDate,
                                         @RequestPart("logDetails") String logDetails
    ) {
        try {
            MonitoringLogDTO monitoringLogDTO = new MonitoringLogDTO();
            monitoringLogDTO.setLogId(AppUtil.generateMonitoringId());
            monitoringLogDTO.setLogDate(logDate);
            monitoringLogDTO.setLogDetails(logDetails);
            monitoringLogService.saveLog(monitoringLogDTO);
            logger.info("Save log successful");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @DeleteMapping(value = "{logId}")
    public ResponseEntity<Void> deleteLog(@PathVariable("logId") String logId) {
        try {
            if (RegexProcess.logIdMatcher(logId) || logId == null) {
                logger.warn("Log id is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            monitoringLogService.deleteLog(logId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (LogNotFound e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @GetMapping
    public List<MonitoringLogDTO> getAllLogs() {
        return monitoringLogService.getAllLogs();
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PutMapping(value = "{logId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateLog(@PathVariable String logId,
                                          @RequestPart("logDetails") String logDetails,
                                          @RequestPart("logDate") String logDate,
                                          @RequestPart("field") String field,
                                          @RequestPart("staff") String staff
    ) {

        try {
            MonitoringLogDTO monitoringLogDTO = new MonitoringLogDTO();
            monitoringLogDTO.setLogId(logId);
            monitoringLogDTO.setLogDate(logDate);
            monitoringLogDTO.setLogDetails(logDetails);
            monitoringLogDTO.setField(field);
            monitoringLogDTO.setStaff(staff);

            if (RegexProcess.logIdMatcher(logId) || logId == null) {
                logger.warn("Log id is not valid");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            monitoringLogService.updateLog(logId, monitoringLogDTO);
            logger.info("Update log successful");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (MonitoringLogNotFoundException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
