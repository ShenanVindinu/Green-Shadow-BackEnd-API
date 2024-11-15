package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.StaffDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.StaffDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.StaffEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.StaffService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceIMPL implements StaffService {

    private final StaffDAO staffDAO;
    private final Mapping mapping;

    private final Logger logger = LoggerFactory.getLogger(StaffServiceIMPL.class);

    @Autowired
    public StaffServiceIMPL(StaffDAO staffDAO, Mapping mapping) {
        this.staffDAO = staffDAO;
        this.mapping = mapping;
    }

    @Override
    public void saveStaffMember(StaffDTO staffDTO) {
        staffDTO.setStaffId(AppUtil.generateStaffId());
        staffDAO.save(mapping.toStaffEntity(staffDTO));
    }

    @Override
    public List<StaffDTO> getALLStaffMembers() {
        return mapping.asStaffDTOList(staffDAO.findAll());
    }

    @Override
    public void deleteStaffMember(String staffId) {
        Optional<StaffEntity> staffEntity = staffDAO.findById(staffId);
        if (staffEntity.isPresent()) {
            staffDAO.deleteById(staffId);
        } else {
            logger.warn("Staff with id {} not found", staffId);
            throw new RuntimeException("Staff with id " + staffId + " not found");
        }
    }

    @Override
    public void updateStaffMember(String staffId, StaffDTO updatedStaffDTO) {
        Optional<StaffEntity> staffEntity = staffDAO.findById(staffId);
        if (staffEntity.isPresent()) {
            updatedStaffDTO.setStaffId(staffId);
            StaffEntity staff = staffEntity.get();
            boolean isIdChanged = !staffId.equals(updatedStaffDTO.getStaffId());

            if (isIdChanged) {
                staffDAO.delete(staff);
            }
            StaffEntity updatedStaffEntity = mapping.toStaffEntity(updatedStaffDTO);
            staffDAO.save(updatedStaffEntity);
        }
    }
}
