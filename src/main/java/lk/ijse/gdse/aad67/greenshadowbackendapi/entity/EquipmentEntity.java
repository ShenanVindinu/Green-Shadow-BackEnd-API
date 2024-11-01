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
@Table(name = "equipment")
public class EquipmentEntity {

    @Id
    private String equipmentId;

    private String equipmentName;
    private Enum equipmentType;
    private Enum equipmentStatus;
    private Staff assignedStaffDetails;
    private Field assignedFieldDetails;


}
