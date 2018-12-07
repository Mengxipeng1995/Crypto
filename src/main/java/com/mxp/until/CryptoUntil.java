package com.mxp.until;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CryptoUntil {

    private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish //$NON-NLS-1$

    /**
     * 3DES加密
     * @param key
     * @param str
     * @return
     */
    public static String encryptMode(String key, String str) {
        try {
            byte[] keybyte = key.getBytes(StandardCharsets.UTF_8); //$NON-NLS-1$
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return bytesToHexString(c1.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e1) {
            //无意义
        }
        return null;
    }


    /**
     * 3DES 解密
     * @param key
     * @param hexSrc
     * @return
     */
    public static String decryptMode(String key, String hexSrc) {
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(key.getBytes("utf8"), Algorithm); //$NON-NLS-1$
            byte[] src = hexStringToBytes(hexSrc);

            //解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            //return c1.doFinal(src);
            return new String(c1.doFinal(src), "utf-8"); //$NON-NLS-1$
        } catch (Exception e1) {
            //无意义
        }
        return null;
    }

    /**
     * MD5 加密
     * @param key
     * @return
     */
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) { //$NON-NLS-1$
            return null;
        }
        String hexStr = hexString.toUpperCase();
        int length = hexStr.length() / 2;
        char[] hexChars = hexStr.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

        }
        return d;
    }
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c); //$NON-NLS-1$
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder(""); //$NON-NLS-1$
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        String paramlist = "{" +
//                "\"stationid\": \"36310001\"," +
//                // "\"gameid\":\"5\"," +
//                "\"machid\": \"T201801010001\"," +
//                "\"key\":\"ch67rl1lzsri4bd6xuckwzk0\"," +
//                "\"certid\":\"8c3fbeebfc73bc7137243d9226d733fc2b1c3fcb9efb8b0a9957c082bdccb55c\"" +
//                "}";
//        //ch67rl1lzsri4bd6xuckwzk0
//        String s = encryptMode("qwertyuiqwertyuiqwertyui", "ss");
//        System.out.println(s);
        System.out.println(MD5("AAA"));
    }

}
