package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity implements SuperEntity {
    @Id
    @Column(name = "field_id")
    private String fieldId;
    private String fieldName;
    private String fieldLocation;
    private Double extentSizeOfTheField;

    @Lob
    private String fieldImage1;
    @Lob
    private String fieldImage2;

    @OneToMany(mappedBy = "field")
    private List<CropEntity> crops;

    @OneToMany(mappedBy = "field")
    private List<MonitoringLogEntity> monitoringLog;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @OneToMany(mappedBy = "fieldId")
    private List<EquipmentEntity> equipment;

}
