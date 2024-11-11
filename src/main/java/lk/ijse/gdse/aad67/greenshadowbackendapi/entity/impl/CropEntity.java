package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;


import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class CropEntity implements SuperEntity {

    @Id
    @Column(name = "cropCode")
    private String cropCode;

    private String cropCommonName;
    private String cropScientificName;

    @Lob
    private String cropImage;

    private String category;
    private String cropSeason;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private FieldEntity field;


}
