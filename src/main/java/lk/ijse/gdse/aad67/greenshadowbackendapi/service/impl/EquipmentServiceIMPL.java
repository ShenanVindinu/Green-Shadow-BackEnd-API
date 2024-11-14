package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.EquipmentDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.EquipmentDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.EquipmentEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.EquipmentNotFound;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.EquipmentService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteEquipment(String equipmentId) {
        Optional<EquipmentEntity> equipmentEntity = equipmentDAO.findById(equipmentId);
        if (equipmentEntity.isEmpty()) {
            throw new EquipmentNotFound("Equipment not found");
        } else {
            equipmentDAO.delete(equipmentEntity.get());
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return mapping.asEquipmentDTOList(equipmentDAO.findAll());
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDTO updatedEquipmentDTO) {
        Optional<EquipmentEntity> equipmentEntity = equipmentDAO.findById(equipmentId);
        updatedEquipmentDTO.setEquipmentId(equipmentId);
        if (equipmentEntity.isPresent()) {
            EquipmentEntity existingEquipment = equipmentEntity.get();

            boolean isIdChanged = !equipmentId.equals(updatedEquipmentDTO.getEquipmentId());

            if (isIdChanged) {
                equipmentDAO.delete(existingEquipment);
            }

            EquipmentEntity newEquipment = mapping.toEquipmentEntity(updatedEquipmentDTO);
            equipmentDAO.save(newEquipment);
        } else {
            throw new EquipmentNotFound("Equipment not found");
        }
    }
}
