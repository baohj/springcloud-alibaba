package com.tjgx.order.common.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
public class AESUtil {
    /**
     * 加解密算法
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS5Padding";
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";

    /**
     * AES 加密
     * @param content 需要被加密的内容
     * @return
     * @throws Exception
     */
    public static String encode(String content,String key) throws Exception {
        log.info("加密之前:{}",content);
        //1、指定算法、获取Cipher对象
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        //SecretKeySpec secretKey = new SecretKeySpec(MD5Util.encode(key).toLowerCase().getBytes(), ALGORITHM);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        //3、用指定的密钥初始化Cipher对象，指定是加密模式，还是解密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //4、加密
        byte[] result = cipher.doFinal(content.getBytes("utf-8"));
        String base64Result = Base64.getEncoder().encodeToString(result);//对加密后的字节数组进行Base64编码
        log.info("加密之后:{}",base64Result);
        return base64Result;
    }

    /**
     * AES 解密
     * @param content 需要解密的内容
     * @return
     * @throws Exception
     */
    public static String decode(String content,String key) throws Exception {
        log.info("解密之前:{}",content);
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        //SecretKeySpec secretKey = new SecretKeySpec(MD5Util.encode(key).toLowerCase().getBytes(), ALGORITHM);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encodedBytes = Base64.getDecoder().decode(content.getBytes("utf-8"));
        byte[] result = cipher.doFinal(encodedBytes);//对加密后的字节数组进行解密
        String str = new String(result);
        log.info("解密之后:{}",str);
        return  str;
    }

}
