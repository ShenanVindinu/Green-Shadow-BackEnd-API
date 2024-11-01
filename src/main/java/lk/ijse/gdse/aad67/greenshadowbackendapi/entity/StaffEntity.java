package lk.ijse.gdse.aad67.greenshadowbackendapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String designation;


    private Enum gender;

    
    private Date joinedDate;
    private Date dob;
    private String addressLine01;
    private String addressLine02;
    private String addressLine03;
    private String addressLine04;
    private String addressLine05;
    private String contactNumber;
    private String email;


    private Enum role;


    private List<Field> field;
    private List<Vehicle> vehicle;

}
