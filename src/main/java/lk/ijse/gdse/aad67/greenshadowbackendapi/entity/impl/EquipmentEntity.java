package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.EquipmentStatus;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity {

    @Id
    private String equipmentId;

    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;
    private Staff assignedStaffDetails;
    private Field assignedFieldDetails;


}
