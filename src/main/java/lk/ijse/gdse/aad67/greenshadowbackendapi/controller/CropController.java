package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.CropDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.CropNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.CropService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
            cropDTO.setCropCode(cropId);
            cropDTO.setCropCommonName(cropCommonName);
            cropDTO.setCropScientificName(cropScientificName);
            cropDTO.setCropImage(base64CropPic);
            cropDTO.setCategory(category);
            cropDTO.setCropSeason(cropSeason);
            cropDTO.setFieldCode(field);
            logger.info(field);
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

    @DeleteMapping(value = "/{cropCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCrop(@PathVariable("cropCode") String cropCode) {
        try {
            if (!RegexProcess.cropIdMatcher(cropCode)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cropService.deleteCrop(cropCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            logger.error("INTERNAL_SERVER_ERROR: Unexpected error", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("INTERNAL_SERVER_ERROR: Unexpected error", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDTO> getAllCrops() {return cropService.getAllCrops();}

    @PutMapping(value = {"{cropCode}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCrop(@PathVariable("cropCode") String cropCode,
                                           @RequestPart("cropCommonName") String cropCommonName,
                                           @RequestPart("cropScientificName") String cropScientificName,
                                           @RequestPart("cropImage") MultipartFile cropImage,
                                           @RequestPart("category") String category,
                                           @RequestPart("cropSeason") String cropSeason,
                                           @RequestPart("field") String field
    )
    {
        String base64CropPic = "";
        try {
            byte[] bytesCropPic = cropImage.getBytes();
            base64CropPic = AppUtil.PicToBase64(bytesCropPic);

            CropDTO updatedCropDto = new CropDTO();
            updatedCropDto.setCropCode(cropCode);
            updatedCropDto.setCropCommonName(cropCommonName);
            updatedCropDto.setCropScientificName(cropScientificName);
            updatedCropDto.setCropImage(base64CropPic);
            updatedCropDto.setCategory(category);
            updatedCropDto.setCropSeason(cropSeason);
            updatedCropDto.setFieldCode(field);

            if (!RegexProcess.cropIdMatcher(cropCode) || cropCode == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cropService.updateCrop(cropCode, updatedCropDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            logger.error("Crop Not Found",e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal Server Error",e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
