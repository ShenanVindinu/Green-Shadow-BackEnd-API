package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.VehicleDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.VehicleDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.VehicleService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceIMPL implements VehicleService {

    private final VehicleDAO vehicleDAO;
    private final Mapping mapping;
    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceIMPL.class);

    @Autowired
    public VehicleServiceIMPL(VehicleDAO vehicleDAO, Mapping mapping) {
        this.vehicleDAO = vehicleDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setVehicleId(AppUtil.generateVehicleId());
        vehicleDAO.save(mapping.toVehicleEntity(vehicleDTO));
    }
}
