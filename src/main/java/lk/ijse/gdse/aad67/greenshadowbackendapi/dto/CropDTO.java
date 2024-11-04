package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;


import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO {

    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;
    private String cropImage;
    private String category;
    private String cropSeason;
    private FieldEntity field;

}
