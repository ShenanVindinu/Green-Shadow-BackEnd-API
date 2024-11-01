package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "monitering_Log")
public class MonitoringLogEntity {
    @Id
    private String logCode;

    private Date logDate;
    private String logDetails;

    @Lob
    private String observedImage;

    @OneToMany
    @JoinColumn(name = "log_field")
    private List<FieldEntity> field;

    @OneToMany
    @JoinColumn(name = "crop_field")
    private List<CropEntity> crop;

    @OneToMany
    @JoinColumn(name = "staff_in_field")
    private List<StaffEntity> staff;
}
