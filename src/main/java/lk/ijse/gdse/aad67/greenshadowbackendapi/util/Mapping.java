package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.EquipmentDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.MonitoringLogDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.*;
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
        MonitoringLogEntity entity = new MonitoringLogEntity();

        // Set basic properties
        entity.setLogId(monitoringLogDTO.getLogId());
        entity.setLogDetails(monitoringLogDTO.getLogDetails());
        entity.setObservedImage(monitoringLogDTO.getObservedImage());

        // Convert and set logDate
        if (monitoringLogDTO.getLogDate() != null) {
            entity.setLogDate(LocalDate.parse(monitoringLogDTO.getLogDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        // Set FieldEntity and StaffEntity
        if (monitoringLogDTO.getField() != null) {
            FieldEntity fieldEntity = new FieldEntity();
            fieldEntity.setFieldId(monitoringLogDTO.getField());
            entity.setField(fieldEntity);
        }

        if (monitoringLogDTO.getStaff() != null) {
            StaffEntity staffEntity = new StaffEntity();
            staffEntity.setStaffId(monitoringLogDTO.getStaff());
            entity.setStaff(staffEntity);
        }

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
