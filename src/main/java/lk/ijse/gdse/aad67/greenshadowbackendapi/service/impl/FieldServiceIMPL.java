package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.FieldDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.FieldNotFound;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.FieldService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceIMPL implements FieldService {

    private final FieldDAO fieldDAO;
    private final Mapping mapping;
    private final Logger logger = LoggerFactory.getLogger(FieldServiceIMPL.class);

    @Autowired
    public FieldServiceIMPL(FieldDAO fieldDAO, Mapping mapping) {
        this.fieldDAO = fieldDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveField(FieldDTO fieldDTO) {
        FieldEntity fieldEntity = mapping.toFieldEntity(fieldDTO);
        fieldDAO.save(fieldEntity);
    }

    @Override
    public List<FieldDTO> getAllFields() {
        return mapping.asFieldDTOList(fieldDAO.findAll());
    }

    @Override
    public void deleteField(String fieldId) {
        Optional<FieldEntity> fieldEntity = fieldDAO.findById(fieldId);
        if (fieldEntity.isEmpty()) {
            throw new FieldNotFound(fieldId+" field Not Found");
        } else {
            fieldDAO.deleteById(fieldId);
        }
    }
}
