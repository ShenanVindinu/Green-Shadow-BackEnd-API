package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;


import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class CropEntity implements SuperEntity {

    @Id
    @Column(name = "crop_id")
    private String cropId;

    private String cropCommonName;
    private String cropScientificName;

    @Lob
    private String cropImage;

    private String category;
    private String cropSeason;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private FieldEntity field;


}
