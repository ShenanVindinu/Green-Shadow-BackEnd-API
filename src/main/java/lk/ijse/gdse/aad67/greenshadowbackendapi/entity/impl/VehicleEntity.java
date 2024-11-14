package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class VehicleEntity implements SuperEntity {

    @Id
    @Column(name = "vehicle_Code")
    private String vehicleCode;

    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private String status;

    private String remarks;

}
