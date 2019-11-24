package com.ffcs.up.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author hxx
 */
public class EncryptUtils {
    private static final String CHARSET = "UTF-8";
    private static final String SECRET = "throwable";

    public static String encryptByAes(String raw) throws Exception {
        Cipher aesCipher = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(SECRET.getBytes(CHARSET)));
        SecretKey secretKey = keyGenerator.generateKey();
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] bytes = aesCipher.doFinal(raw.getBytes(CHARSET));
        return Hex.encodeHexString(bytes);

    }

    public static String decryptByAes(String raw) throws Exception {
        byte[] bytes = Hex.decodeHex(raw);
        Cipher aesCipher = Cipher.getInstance("AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(SECRET.getBytes(CHARSET)));
        SecretKey secretKey = keyGenerator.generateKey();
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return new String(aesCipher.doFinal(bytes), CHARSET);
    }


}
