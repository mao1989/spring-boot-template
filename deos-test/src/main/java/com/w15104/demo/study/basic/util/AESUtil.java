package com.w15104.demo.study.basic.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.w15104.demo.study.basic.exception.CommonException;
import com.w15104.demo.study.basic.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

/*
 *
 * @Description AES加密解密类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Slf4j
public class AESUtil {

	private AESUtil() {}
	
    /**
     * 算法名
     */
    private static final String ALGO = "AES";

    /**
     * 算法/工作模式/填充模式
     */
    private static final String ALGO_MODE = "AES/CBC/PKCS5Padding";

    /**
     * 私钥
     */
    private static final String KEY = "KLAGAASXDSAKLXCN";

    /**
     * 初始化向量参数
     */
    private static final String IV = "KLAGAASXDSAKLXCN";

    /**
     * 编码类型
     */
    private static final String ENCODING = "utf-8";

    private static Cipher encode;
    private static Cipher decode;

    /**
     * 静态方法，在初始化类时候执行
     */
    static {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(ENCODING), ALGO);
            IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes(ENCODING));
            encode = Cipher.getInstance(ALGO_MODE);
            encode.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            decode = Cipher.getInstance(ALGO_MODE);
            decode.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            log.error("算法不存在异常");
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码异常");
        } catch (InvalidKeyException e) {
            log.error("无效key异常");
        } catch (InvalidAlgorithmParameterException e) {
            log.error("算法参数不正确");
        }
    }

    /**
     * AES 加密
     * @param clearPwd 明文字符串
     * @return 密文字符串
     * @throws CommonException 异常
     */
    public static String encrypt(String clearPwd) {
        try {
            byte[] clearPwdBytes = clearPwd.getBytes(ENCODING);
            byte[] encrypted = encode.doFinal(clearPwdBytes);
            return new String(Base64.encodeBase64(encrypted));
        } catch (Exception e) {
            throw new CommonException(ErrorCode.E_00008, e);
        }
    }

    /**
     * AES 解密
     * @param encrypted 密文字符串
     * @return 明文字符串
     * @throws CommonException 异常
     */
    public static String decrypt(String encrypted) {
        try {
            return new String(decode.doFinal(Base64.decodeBase64(encrypted)), ENCODING);
        } catch (Exception e) {
            throw new CommonException(ErrorCode.E_00009, e);
        }
    }

}
