package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;


import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "equipment_assigned_staff_details")
    private StaffEntity assignedStaffDetails;

    @ManyToOne
    @JoinColumn(name = "equipment_assigned_field_details")
    private FieldEntity assignedFieldDetails;


}
