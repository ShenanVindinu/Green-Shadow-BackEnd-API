package lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.SuperEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.VehicleStatus;
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
    @Column(name = "vehicle_id")
    private String vehicleId;

    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;

    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    private String remarks;

}
