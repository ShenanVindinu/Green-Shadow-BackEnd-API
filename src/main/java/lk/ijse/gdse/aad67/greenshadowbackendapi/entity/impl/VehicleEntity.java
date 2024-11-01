package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    private String vehicleCode;

    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private String status;

    @OneToOne
    @JoinColumn(name = "allocatedStaffMemberDetail")
    private StaffEntity allocatedStaffMemberDetails;

    private String remarks;

}
