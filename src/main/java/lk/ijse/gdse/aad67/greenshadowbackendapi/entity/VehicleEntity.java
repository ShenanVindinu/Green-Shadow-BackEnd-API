package lk.ijse.gdse.aad67.greenshadowbackendapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Staff allocatedStaffMemberDetails;
    private String remarks;

}
