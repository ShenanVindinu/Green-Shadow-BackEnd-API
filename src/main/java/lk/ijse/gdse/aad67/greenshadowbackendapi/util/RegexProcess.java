package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean cropIdMatcher(String cropId) {
        String regexForUserID = "^CROP-[a-f0-9]{5}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return !pattern.matcher(cropId).matches();
    }

    public static boolean equipmentIdMatcher(String equipmentId) {
        String regexForUserID = "^EQUIPMENT-[a-f0-9]{5}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return pattern.matcher(equipmentId).matches();
    }

    public static boolean fieldIdMatcher(String fieldId) {
        String regexForUserID = "^FIELD-[a-f0-9]{5}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return !pattern.matcher(fieldId).matches();
    }

    public static boolean logIdMatcher(String logId) {
        String regexForUserID = "^MONITORING-[a-f0-9]{5}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return !pattern.matcher(logId).matches();
    }

    public static boolean staffIdMatcher(String staffId) {
        String regexForUserID = "^STAFF-[a-f0-9]{5}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return !pattern.matcher(staffId).matches();
    }

    public static boolean vehicleIdMatcher(String vehicleId) {
        String regexForUserID = "^VEHICLE-[a-f0-9]{5}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return !pattern.matcher(vehicleId).matches();
    }
}
