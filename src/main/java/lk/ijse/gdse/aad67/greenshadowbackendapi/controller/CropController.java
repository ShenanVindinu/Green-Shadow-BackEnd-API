package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.CropService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/crop")
public class CropController {

    private final CropService cropService;

    @Autowired
    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    private static final Logger logger = LoggerFactory.getLogger(CropController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("cropCode") String cropCode,
            @RequestPart("cropCommonName") String cropCommonName,
            @RequestPart("cropScientificName") String cropScientificName,
            @RequestPart("cropImage") MultipartFile cropImage,
            @RequestPart("category") String category,
            @RequestPart("cropSeason") String cropSeason,
            @RequestPart("field") String field

            ) {
        String base64CropPic = "";
        try {

            byte[] bytesCropPic = cropImage.getBytes();
            base64CropPic = AppUtil.PicToBase64(bytesCropPic);

            String cropId = AppUtil.generateCropId();

            CropDTO cropDTO = new CropDTO();
            cropDTO.setCropCode(cropCode);
            cropDTO.setCropCommonName(cropCommonName);
            cropDTO.setCropScientificName(cropScientificName);
            cropDTO.setCropImage(base64CropPic);
            cropDTO.setCategory(category);
            cropDTO.setCropSeason(cropSeason);
            cropDTO.setField(field);

            cropService.saveCrop(cropDTO);
            logger.info("Crop Saved Successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            logger.error("BAD_REQUEST: Error processing request", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("INTERNAL_SERVER_ERROR: Unexpected error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
