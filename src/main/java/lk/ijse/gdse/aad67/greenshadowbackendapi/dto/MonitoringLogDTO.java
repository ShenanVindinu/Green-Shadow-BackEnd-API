package lk.ijse.gdse.aad67.greenshadowbackendapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDTO {

    private String logCode;
    private Date logDate;
    private String logDetails;
    private String observedImage;
    private String field;
    private String staff;

}
