package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.MonitoringLogService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/Mlog")
public class MonitoringLogController {

    private final MonitoringLogService monitoringLogService;

    private static final Logger logger = LoggerFactory.getLogger(MonitoringLogController.class);

    @Autowired
    public MonitoringLogController(MonitoringLogService monitoringLogService) {
        this.monitoringLogService = monitoringLogService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog( @RequestPart("logDate") String logDate,
                                         @RequestPart("logDetails") String logDetails,
                                         @RequestPart("observedImage") String observedImage
    ) {
        String base64ObservedImage = "";
        try {
            base64ObservedImage = AppUtil.PicToBase64(observedImage.getBytes());

            MonitoringLogDTO monitoringLogDTO = new MonitoringLogDTO();
            monitoringLogDTO.setLogId(AppUtil.generateMonitoringLogId());
            monitoringLogDTO.setLogDate(logDate);
            monitoringLogDTO.setLogDetails(logDetails);
            monitoringLogDTO.setObservedImage(base64ObservedImage);
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

}
