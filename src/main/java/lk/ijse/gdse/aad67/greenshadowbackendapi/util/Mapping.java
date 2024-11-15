package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.*;
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

    //staff
    public StaffEntity toStaffEntity(StaffDTO staffDTO) {
        StaffEntity entity = new StaffEntity();

        // Map basic properties
        entity.setStaffId(staffDTO.getStaffId());
        entity.setFirstName(staffDTO.getFirstName());
        entity.setLastName(staffDTO.getLastName());
        entity.setDesignation(staffDTO.getDesignation());
        entity.setGender(staffDTO.getGender());
        entity.setJoinedDate(staffDTO.getJoinedDate());
        entity.setDob(staffDTO.getDob());
        entity.setAddressLine01(staffDTO.getAddressLine01());
        entity.setAddressLine02(staffDTO.getAddressLine02());
        entity.setAddressLine03(staffDTO.getAddressLine03());
        entity.setAddressLine04(staffDTO.getAddressLine04());
        entity.setAddressLine05(staffDTO.getAddressLine05());
        entity.setContactNumber(staffDTO.getContactNumber());
        entity.setEmail(staffDTO.getEmail());
        entity.setRole(staffDTO.getRole());


        if (staffDTO.getVehicle() != null) {
            VehicleEntity vehicleEntity = new VehicleEntity();
            vehicleEntity.setVehicleId(staffDTO.getVehicle());
            entity.setVehicle(vehicleEntity);
        }


        if (staffDTO.getEquipment() != null) {
            entity.setEquipment(staffDTO.getEquipment());
        }

        if (staffDTO.getMonitoringLog() != null) {
            entity.setMonitoringLog(staffDTO.getMonitoringLog());
        }

        return entity;
    }
    public List<StaffDTO> asStaffDTOList(List<StaffEntity> staffEntities) {
        List<StaffDTO> staffDTOList = new ArrayList<>();

        for (StaffEntity entity : staffEntities) {
            StaffDTO dto = new StaffDTO();

            // Map basic properties
            dto.setStaffId(entity.getStaffId());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setDesignation(entity.getDesignation());
            dto.setGender(entity.getGender());
            dto.setJoinedDate(entity.getJoinedDate());
            dto.setDob(entity.getDob());
            dto.setAddressLine01(entity.getAddressLine01());
            dto.setAddressLine02(entity.getAddressLine02());
            dto.setAddressLine03(entity.getAddressLine03());
            dto.setAddressLine04(entity.getAddressLine04());
            dto.setAddressLine05(entity.getAddressLine05());
            dto.setContactNumber(entity.getContactNumber());
            dto.setEmail(entity.getEmail());
            dto.setRole(entity.getRole());


            if (entity.getVehicle() != null) {
                dto.setVehicle(entity.getVehicle().getVehicleId());
            }


            if (entity.getEquipment() != null) {
                dto.setEquipment(entity.getEquipment());
            }


            if (entity.getMonitoringLog() != null) {
                dto.setMonitoringLog(entity.getMonitoringLog());
            }

            staffDTOList.add(dto);
        }

        return staffDTOList;
    }

    //Vehicle
    public VehicleEntity toVehicleEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }
}
