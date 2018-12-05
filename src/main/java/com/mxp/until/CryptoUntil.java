package com.mxp.until;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

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
        String paramlist = "{" +
                "\"stationid\": \"36310001\"," +
                // "\"gameid\":\"5\"," +
                "\"machid\": \"T201801010001\"," +
                "\"key\":\"ch67rl1lzsri4bd6xuckwzk0\"," +
                "\"certid\":\"8c3fbeebfc73bc7137243d9226d733fc2b1c3fcb9efb8b0a9957c082bdccb55c\"" +
                "}";
        //ch67rl1lzsri4bd6xuckwzk0
        String s = encryptMode("qwertyuiqwertyuiqwertyui", "ss");
        System.out.println(s);
    }

}