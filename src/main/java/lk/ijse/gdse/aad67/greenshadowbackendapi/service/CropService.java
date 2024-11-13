package lk.ijse.gdse.aad67.greenshadowbackendapi.service;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);

    void deleteCrop(String cropCode);

    List<CropDTO> getAllCrops();

    void updateCrop(String cropCode, CropDTO updatedCropDto);
}
