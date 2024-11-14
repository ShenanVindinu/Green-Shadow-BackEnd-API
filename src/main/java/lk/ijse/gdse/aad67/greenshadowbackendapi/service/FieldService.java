package lk.ijse.gdse.aad67.greenshadowbackendapi.service;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);

    List<FieldDTO> getAllFields();

    void deleteField(String fieldId);

    void updateField(String fieldId, FieldDTO fieldDTO);
}
