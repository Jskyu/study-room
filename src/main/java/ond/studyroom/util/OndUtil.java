package ond.studyroom.util;

public class OndUtil {
    public static Long stringToLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
