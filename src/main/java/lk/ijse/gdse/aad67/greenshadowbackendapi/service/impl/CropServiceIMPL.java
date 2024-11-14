package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.CropDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.CropEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.CropNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.CropService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CropServiceIMPL implements CropService {

    private final CropDAO cropDAO;
    private final Mapping mapping;
    private final Logger logger = LoggerFactory.getLogger(CropServiceIMPL.class);

    public CropServiceIMPL(CropDAO cropDAO, Mapping mapping) {
        this.cropDAO = cropDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveCrop(CropDTO cropDTO) {
        logger.info(cropDTO.getFieldCode());
        cropDAO.save(mapping.toCropEntity(cropDTO));
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<CropEntity> findCrop = cropDAO.findById(cropCode);
        if(findCrop.isEmpty()) {
            throw new CropNotFoundException("Crop Not Found");
        } else {
            cropDAO.deleteById(cropCode);
        }
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return mapping.asCropDTOList(cropDAO.findAll());
    }

    @Override
    public void updateCrop(String cropCode, CropDTO updatedCropDto) {
        Optional<CropEntity> optionalCrop = cropDAO.findById(cropCode);
        if (optionalCrop.isPresent()) {
            CropEntity existingCrop = optionalCrop.get();

            boolean isIdChanged = !cropCode.equals(updatedCropDto.getCropId());

            if (isIdChanged) {
                cropDAO.delete(existingCrop);
            }

            CropEntity newCrop = mapping.toCropEntity(updatedCropDto);
            cropDAO.save(newCrop);

        } else {
            throw new CropNotFoundException("Crop with code " + cropCode + " not found");
        }
    }
}
