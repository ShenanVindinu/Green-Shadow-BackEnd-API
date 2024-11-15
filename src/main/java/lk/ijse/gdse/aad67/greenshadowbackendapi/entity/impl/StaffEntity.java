package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Gender;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.Role;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements SuperEntity {
    @Id
    @Column(name = "staff_id")
    private String staffId;

    private String firstName;
    private String lastName;
    private String designation;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate joinedDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dob;

    @Column(name = "building_no")
    private String addressLine01;

    @Column(name = "Lane")
    private String addressLine02;

    @Column(name = "city")
    private String addressLine03;

    @Column(name = "main_state")
    private String addressLine04;

    @Column(name = "postal_code")
    private String addressLine05;

    private String contactNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @OneToMany(mappedBy = "staffId")
    private List<EquipmentEntity> equipment;

    @OneToMany(mappedBy = "staff")
    private List<MonitoringLogEntity> monitoringLog;



}
