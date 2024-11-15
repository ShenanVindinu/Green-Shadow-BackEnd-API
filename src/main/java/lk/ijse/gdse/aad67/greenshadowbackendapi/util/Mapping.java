package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.EquipmentDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.CropEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.EquipmentEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.MonitoringLogEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class Mapping {

    private final ModelMapper modelMapper;

    @Autowired
    public Mapping(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    //Crop
    public CropEntity toCropEntity(CropDTO cropDTO){
        return modelMapper.map(cropDTO,CropEntity.class);
    }
    public List<CropDTO> asCropDTOList(List<CropEntity> cropEntities) {
        return modelMapper.map(cropEntities, new TypeToken<List<CropDTO>>() {}.getType());
    }

    //Equipment
    public EquipmentEntity toEquipmentEntity(EquipmentDTO equipmentDTO) {
        return modelMapper.map(equipmentDTO,EquipmentEntity.class);
    }
    public List<EquipmentDTO> asEquipmentDTOList(List<EquipmentEntity> equipmentEntities) {
        return modelMapper.map(equipmentEntities, new TypeToken<List<EquipmentDTO>>() {}.getType());
    }


    //Field
    public FieldEntity toFieldEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO,FieldEntity.class);
    }
    public List<FieldDTO> asFieldDTOList(List<FieldEntity> all) {
        return modelMapper.map(all, new TypeToken<List<FieldDTO>>() {}.getType());
    }

    //Monitoring Log
    public MonitoringLogEntity toMonitoringLogEntity(MonitoringLogDTO monitoringLogDTO) {
        MonitoringLogEntity entity = modelMapper.map(monitoringLogDTO, MonitoringLogEntity.class);
        entity.setLogDate(LocalDate.parse(monitoringLogDTO.getLogDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return entity;
    }
    public List<MonitoringLogDTO> asMonitoringLogDTOList(List<MonitoringLogEntity> monitoringLogEntities) {
        List<MonitoringLogDTO> dtoList = new ArrayList<>();

        for (MonitoringLogEntity entity : monitoringLogEntities) {
            MonitoringLogDTO dto = new MonitoringLogDTO();


            dto.setLogId(entity.getLogId());


            dto.setLogDate(entity.getLogDate() != null ? entity.getLogDate().toString() : null);

            dto.setLogDetails(entity.getLogDetails());
            dto.setObservedImage(entity.getObservedImage());


            dto.setField(entity.getField() != null ? entity.getField().getFieldName() : null);
            dto.setStaff(entity.getStaff() != null ? entity.getStaff().getFirstName() : null);

            dtoList.add(dto);
        }

        return dtoList;
    }
}
