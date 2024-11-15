package lk.ijse.gdse.aad67.greenshadowbackendapi.service.impl;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dao.StaffDAO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.StaffDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.StaffService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.AppUtil;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceIMPL implements StaffService {

    private final StaffDAO staffDAO;
    private final Mapping mapping;

    private final Logger log = LoggerFactory.getLogger(StaffServiceIMPL.class);

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
}
