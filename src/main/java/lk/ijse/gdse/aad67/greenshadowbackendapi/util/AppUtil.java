package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateUserId(){
        return "USER-"+UUID.randomUUID();
    }
    public static String generateCropId(){
        return "CROP-"+UUID.randomUUID();
    }
    public static String generateEquipmentId(){
        return "EQUIPMENT-"+UUID.randomUUID();
    }
    public static String generateFieldId(){
        return "FIELD-"+UUID.randomUUID();
    }
    public static String generateMonitoringId(){
        return "MONITORING-"+UUID.randomUUID();
    }
    public static String generateStaffId(){
        return "STAFF-"+UUID.randomUUID();
    }
    public static String generateMonitoringLogId(){
        return "MonitoringLOG-"+UUID.randomUUID();
    }
    public static String generateVehicleId(){
        return "Vehicle-"+UUID.randomUUID();
    }

    public static String PicToBase64(byte[] bytesCropPic) {
        return Base64.getEncoder().encodeToString(bytesCropPic);
    }

}
