package com.xwz.seckill.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * MD5工具类
 * @author xwz
 * @since 1.0
 */
@Component
public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt="1a2b3c4d";

    /**
     * 第一次加密
     * @param inputPass 前端传来的密码
     * @return md5(salt与inputPass的混合)
     */
    public static String inputPassToFromPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 第二次加密
     * @param formPass 第一次加密后的密码
     * @param salt 新的盐，要存到数据库的盐
     * @return md5(新盐+第一次加密后的密码) ,要存入数据库
     */
    public static String formPassToDBPass(String formPass, String salt){
        String str = ""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 加密方法
     * @param inputPass 前端输入的密码
     * @param salt 盐
     * @return 存入数据库的密码
     */
    public static String inputPassToDBpass(String inputPass, String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        // d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        System.out.println(inputPassToDBpass("123456","1a2b3c4d"));
    }
}
