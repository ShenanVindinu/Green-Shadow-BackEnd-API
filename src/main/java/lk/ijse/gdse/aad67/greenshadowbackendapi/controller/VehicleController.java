package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.VehicleDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleService.saveVehicle(vehicleDTO);
            logger.info("Vehicle saved");
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
