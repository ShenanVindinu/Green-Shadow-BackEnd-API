package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.CropEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    @Autowired
    private final ModelMapper modelMapper;

    public Mapping(){
        this.modelMapper = new ModelMapper();
    }

    public CropEntity toCropEntity(CropDTO cropDTO){
        return modelMapper.map(cropDTO,CropEntity.class);
    }



}
