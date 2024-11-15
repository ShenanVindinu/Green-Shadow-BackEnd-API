package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "monitoring_log")
public class MonitoringLogEntity implements SuperEntity {
    @Id
    @Column(name = "log_id")
    private String logId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate logDate;
    private String logDetails;

    @Lob
    private String observedImage;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private FieldEntity field;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;
}
