package lk.ijse.gdse.aad67.greenshadowbackendapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
public class FieldEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extentSizeOfTheField;

    private List<Crop> crops;
    private List<Staff> staff;

    @Lob
    private String fieldImage1;
    @Lob
    private String fieldImage2;

}
