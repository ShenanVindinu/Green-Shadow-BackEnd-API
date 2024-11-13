package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.EquipmentDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.EquipmentDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.EquipmentEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.EquipmentService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceIMPL implements EquipmentService {

    private final EquipmentDAO equipmentDAO;
    private final Mapping mapping;
    private final Logger logger = LoggerFactory.getLogger(EquipmentServiceIMPL.class);

    @Autowired
    public EquipmentServiceIMPL(EquipmentDAO equipmentDAO, Mapping mapping) {
        this.equipmentDAO = equipmentDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        EquipmentEntity equipmentEntity = mapping.toEquipmentEntity(equipmentDTO);
        equipmentDAO.save(equipmentEntity);
    }
}
