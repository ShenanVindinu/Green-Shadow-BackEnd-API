package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateUserId(){
        return "USER-"+UUID.randomUUID().toString().substring(0, 5);
    }
    public static String generateCropId(){
        return "CROP-"+UUID.randomUUID().toString().substring(0, 5);
    }
    public static String generateEquipmentId(){
        return "EQUIPMENT-"+UUID.randomUUID().toString().substring(0, 5);
    }
    public static String generateFieldId(){
        return "FIELD-"+UUID.randomUUID().toString().substring(0, 5);
    }
    public static String generateMonitoringId(){
        return "MONITORING-"+UUID.randomUUID().toString().substring(0, 5);
    }
    public static String generateStaffId(){
        return "STAFF-"+UUID.randomUUID().toString().substring(0, 5);
    }
    public static String generateVehicleId(){
        return "VEHICLE-"+UUID.randomUUID().toString().substring(0, 5);
    }

    public static String PicToBase64(byte[] bytesCropPic) {
        return Base64.getEncoder().encodeToString(bytesCropPic);
    }

}
