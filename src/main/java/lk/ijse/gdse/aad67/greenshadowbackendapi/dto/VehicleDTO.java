package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;

import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.VehicleStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {

    private String vehicleId;
    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private VehicleStatus vehicleStatus;
    private String remarks;

}
