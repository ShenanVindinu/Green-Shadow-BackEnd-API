package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Gender;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Role;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements SuperEntity {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String designation;

    @Enumerated(EnumType.STRING)
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

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    @JoinColumn(name = "staff_memmber_fields")
    private List<FieldEntity> field;

    @OneToMany
    @JoinColumn(name = "staff_memmber_vehicles")
    private List<VehicleEntity> vehicle;

}
