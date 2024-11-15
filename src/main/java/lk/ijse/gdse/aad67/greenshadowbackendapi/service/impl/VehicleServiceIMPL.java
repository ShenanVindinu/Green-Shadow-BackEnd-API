package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.VehicleDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.VehicleDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.VehicleEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.VehicleNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.VehicleService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapping.asVehicleEntity(vehicleDAO.findAll());
    }

    @Override
    public void updateVehicle(String vehicleId, VehicleDTO updatedVehicleDTO) {
        Optional<VehicleEntity> optionalVehicleEntity = vehicleDAO.findById(vehicleId);
        if (optionalVehicleEntity.isPresent()) {
            VehicleEntity vehicle = optionalVehicleEntity.get();

            boolean isChanged = !vehicleId.equals(updatedVehicleDTO.getVehicleId());

            if (isChanged) {
                vehicleDAO.delete(vehicle);
            }
            updatedVehicleDTO.setVehicleId(vehicleId);
            VehicleEntity newVehicleEntity = mapping.toVehicleEntity(updatedVehicleDTO);
            vehicleDAO.save(newVehicleEntity);

        } else {
            throw new VehicleNotFoundException(vehicleId);
        }
    }
}
