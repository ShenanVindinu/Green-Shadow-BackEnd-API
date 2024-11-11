package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;


import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.EquipmentStatus;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.EquipmentType;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity {

    @Id
    @Column(name = "equipmentId")
    private String equipmentId;

    private String equipmentName;
    private EquipmentType equipmentType;
    private EquipmentStatus equipmentStatus;

    @OneToOne
    @JoinColumn(name = "equipment_assigned_staff_id")
    private StaffEntity assignedStaffDetails;

    @OneToOne
    @JoinColumn(name = "equipment_assigned_field_id")
    private FieldEntity assignedFieldDetails;


}
