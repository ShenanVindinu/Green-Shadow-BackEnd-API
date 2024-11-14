package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "monitoring_log")
public class MonitoringLogEntity implements SuperEntity {
    @Id
    @Column(name = "log_id")
    private String logId;

    private Date logDate;
    private String logDetails;

    @Lob
    private String observedImage;


}
