package UTIL;

import java.security.MessageDigest;

public class MaHoa {
    public static String toSHA1(String str) {
        String result = null;
        try {
            // Mã hóa SHA-1 không có salt, giống như cách SQL Server thực hiện
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] dataBytes = str.getBytes("UTF-8");
            byte[] digestBytes = md.digest(dataBytes);

            // Chuyển đổi mảng byte thành chuỗi Hex (40 ký tự)
            StringBuilder hexString = new StringBuilder();
            for (byte b : digestBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Đảm bảo rằng mỗi byte có 2 ký tự
                }
                hexString.append(hex);
            }
            result = hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
