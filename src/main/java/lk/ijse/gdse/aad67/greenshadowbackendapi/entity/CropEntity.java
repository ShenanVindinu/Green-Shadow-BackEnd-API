package lk.ijse.gdse.aad67.greenshadowbackendapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class CropEntity {

    @Id
    private String cropCode;

    private String cropCommonName;
    private String cropScientificName;

    @Lob
    private String cropImage;
    private String category;
    private String cropSeason;

    private Field field;


}
