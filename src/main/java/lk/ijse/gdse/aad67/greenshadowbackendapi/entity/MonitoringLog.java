package lk.ijse.gdse.aad67.greenshadowbackendapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "monitering_Log")
public class MonitoringLog {
    @Id
    private String logCode;

    private Date logDate;
    private String logDetails;

    @Lob
    private String observedImage;

    private List<Field> field;
    private List<Crop> crop;
    private List<Staff> staff;
}
