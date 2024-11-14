package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;


import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.EquipmentEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.MonitoringLogEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO {

    private String fieldId;
    private String fieldName;
    private String fieldLocation;
    private Double extentSizeOfTheField;
    private String fieldImage1;
    private String fieldImage2;
    private List<CropDTO> crops;
    private List<MonitoringLogEntity> monitoringLog;

}
