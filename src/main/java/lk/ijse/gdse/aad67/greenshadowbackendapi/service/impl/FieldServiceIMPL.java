package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.FieldDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.FieldDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.FieldService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
