package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Gender;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO {

    private String id;
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
    private List<FieldDTO> field;
    private List<VehicleDTO> vehicle;

}
