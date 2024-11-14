package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Gender;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Role;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.EquipmentEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.FieldEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.MonitoringLogEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO {

    private String staffId;
    private String firstName;
    private String lastName;
    private String designation;
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNumber;
    private String email;
    private Role role;
    private String vehicle;
    private List<EquipmentEntity> equipment;
    private List<MonitoringLogEntity> monitoringLog;

}
