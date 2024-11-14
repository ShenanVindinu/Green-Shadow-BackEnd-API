package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.EquipmentStatus;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO {

    private String equipmentId;
    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;
    private String staffId;

}
