package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.EquipmentDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.CropEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.EquipmentEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public FieldEntity toFieldEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO,FieldEntity.class);
    }
}
