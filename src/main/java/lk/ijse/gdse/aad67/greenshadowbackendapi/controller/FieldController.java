package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.FieldNotFound;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.FieldService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/field")
public class FieldController {

    private final FieldService fieldService;

    @Autowired
    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    private static final Logger logger = LoggerFactory.getLogger(FieldController.class);

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            @RequestPart("fieldLocation") String fieldLocation,
            @RequestPart("extentSizeOfTheField") String extentSizeOfTheField,
            @RequestPart("fieldImage1") String fieldImage1,
            @RequestPart("fieldImage2") String fieldImage2
    ) {
        String base64FieldPic1 = "";
        String base64FieldPic2 = "";

        try {
            byte[] bytesFieldPic1 = fieldImage1.getBytes();
            byte[] bytesFieldPic2 = fieldImage2.getBytes();
            base64FieldPic1 = AppUtil.PicToBase64(bytesFieldPic1);
            base64FieldPic2 = AppUtil.PicToBase64(bytesFieldPic2);

            String FieldId = AppUtil.generateFieldId();

            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldId(FieldId);
            fieldDTO.setFieldName(fieldName);
            fieldDTO.setFieldLocation(fieldLocation);
            fieldDTO.setExtentSizeOfTheField(Double.valueOf(extentSizeOfTheField));
            fieldDTO.setFieldImage1(base64FieldPic1);
            fieldDTO.setFieldImage2(base64FieldPic2);
            fieldService.saveField(fieldDTO);
            logger.info("Save field successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllFields() {
        return fieldService.getAllFields();
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping(value = "{fieldId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteField(@PathVariable("fieldId") String fieldId) {
        try {
            if (!RegexProcess.fieldIdMatcher(fieldId) || fieldId == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            fieldService.deleteField(fieldId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FieldNotFound e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping(value = "{fieldId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateField(@PathVariable("fieldId") String fieldId,
                                            @RequestPart("fieldName") String fieldName,
                                            @RequestPart("fieldLocation") String fieldLocation,
                                            @RequestPart("extentSizeOfTheField") String extentSizeOfTheField,
                                            @RequestPart("fieldImage1") String fieldImage1,
                                            @RequestPart("fieldImage2") String fieldImage2
    ) {
        String base64FieldPic1 = "";
        String base64FieldPic2 = "";
        try {
            byte[] bytesFieldPic1 = fieldImage1.getBytes();
            byte[] bytesFieldPic2 = fieldImage2.getBytes();
            base64FieldPic1 = AppUtil.PicToBase64(bytesFieldPic1);
            base64FieldPic2 = AppUtil.PicToBase64(bytesFieldPic2);

            FieldDTO updatedFieldDTO = new FieldDTO();
            updatedFieldDTO.setFieldId(fieldId);
            updatedFieldDTO.setFieldName(fieldName);
            updatedFieldDTO.setFieldLocation(fieldLocation);
            updatedFieldDTO.setExtentSizeOfTheField(Double.valueOf(extentSizeOfTheField));
            updatedFieldDTO.setFieldImage1(base64FieldPic1);
            updatedFieldDTO.setFieldImage2(base64FieldPic2);
            if (!RegexProcess.fieldIdMatcher(fieldId) || fieldId == null) {
                throw new FieldNotFound(fieldId+" Field not found");
            } else {
                fieldService.updateField(fieldId,updatedFieldDTO);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (FieldNotFound e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
