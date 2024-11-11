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
    @Column(name = "fieldCode")
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extentSizeOfTheField;

    @OneToMany(mappedBy = "cropCode")
    private List<CropEntity> crops;

    @OneToMany(mappedBy = "staffId")
    private List<StaffEntity> staff;

    @Lob
    private String fieldImage1;
    @Lob
    private String fieldImage2;

}
