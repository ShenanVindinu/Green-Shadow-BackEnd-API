package lk.ijse.gdse.aad67.greenshadowbackendapi.service;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaffMember(StaffDTO staffDTO);

    List<StaffDTO> getALLStaffMembers();

    void deleteStaffMember(String staffId);
}
