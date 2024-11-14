package lk.ijse.gdse.aad67.greenshadowbackendapi.util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean cropIdMatcher(String cropId) {
        String regexForUserID = "^CROP-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return pattern.matcher(cropId).matches();
    }

    public static boolean equipmentIdMatcher(String equipmentId) {
        String regexForUserID = "^EQUIPMENT-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern pattern = Pattern.compile(regexForUserID);
        return pattern.matcher(equipmentId).matches();
    }
}
