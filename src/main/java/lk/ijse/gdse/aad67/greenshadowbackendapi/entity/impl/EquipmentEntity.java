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
    @Column(name = "equipment_id")
    private String equipmentId;

    private String equipmentName;

    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus equipmentStatus;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staffId;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private FieldEntity fieldId;



}
