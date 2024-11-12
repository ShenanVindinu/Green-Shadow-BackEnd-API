package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO {

    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private Double extentSizeOfTheField;
    private List<CropDTO> crops;
    private List<StaffDTO> staff;
    private String fieldImage1;
    private String fieldImage2;

}
