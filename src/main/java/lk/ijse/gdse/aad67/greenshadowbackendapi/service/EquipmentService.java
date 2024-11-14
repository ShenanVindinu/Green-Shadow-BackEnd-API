package lk.ijse.gdse.aad67.greenshadowbackendapi.service;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.EquipmentDTO;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);

    void deleteEquipment(String equipmentId);
}
