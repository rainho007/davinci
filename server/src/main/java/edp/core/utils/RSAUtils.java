package edp.core.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * @Author: admin
 * @Date 2019/7/12
 */
public class RSAUtils {
    private RSAUtils() {
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.getDecoder().decode(str.getBytes(StandardCharsets.UTF_8));
        //base64编码的私钥
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        return new String(cipher.doFinal(inputByte));
    }

    public static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCF5+rVsWLd76B4m9WvLxtqvztmxjemWNuc8zpcCQejwKeAKuOJWE2lXFys+u8ms1On" +
            "cJzAGo7DsGVoskHetAv6iTEyuUnZCdowmD0EJXoL5mT6CKpYpfPvrHmerQya810of5WNkhPZQOcBQyb5+LWkAjxAs0aBGS0O6Drj80Hvs9dIcMsKVI/8Ajgcm+3vCJ83" +
            "81p9e3IzchSPyaovo9pvkNmqVsXmpBw7XrJf24L9jW/ZlR97qbhROy8ximLpBCrm6HAzT69rDQHXr7yqV4qL6A6JwzkccW0gK9Yfyfl3c4wAaCwuZf4EEuDr4ACdz1va" +
            "X9Eaf8+MdeRHXFNulN8RAgMBAAECggEAIa2ht5tEtXMGVi9DgCsF50QviXrDFlh067WU8P7oZ/wVZLvkvG90H+np+SunqIEjwhIlqn9Ddt5PsxRaUsvP03Rb5lkJxMeg" +
            "k+ZGOlu+pW2N6gDx7xfWEWq8r/bwG6ynun7UO2YJDfQv5XZhQC+YZ6aURuWQDvopBf3MifZtl/6zNyt2FPpDpw5HGDce3pTnOl+n6MFqoJ+zGyuQP0Qp+6IEIGrjzwM/" +
            "GD/b5IAvSBCkzYlsYmPYCx7dPL1nmW9Ye1dIde7fxXmouKqlLypxNPT+M4jhmDyJgSBP1Pc/OOpDNWgMV40trzoUtJpz0dUlaVScphxmNVOWPmQ8ppwh7QKBgQC9dG+y" +
            "mU4gxr/1euFUhpF80BBsdHOXTpKSc34Ul8F5WZ+YcifBD/rrqO3PCdcEekz5LOyMLcfsx3gBxiDv+inMMKMNtirFxnXVMZm6dzF/NuhRW6rIKIX6lTpZCWkQBd6P46pa" +
            "zNiPm0m7FO/+N3LJJfiOAu3Jjeszsdl75LjVnwKBgQC08JYs07xbRs9juJJnPz/Mw0INwk/x2TRAGusJRZ/6zPogdSCuHTPZpuloVtbp5CbeyuDsdLjNN08XjtAewbRt" +
            "vEkFp+F3KEm7p5I+nnGRBJtL6y+cl/EyrxJWcQxXgqybFCoO8+jz5K5vbl0j5Wgvw4u+vWlLt8j1+kEVF0ItTwKBgQCLInHNliz8gToEjCPjsZgzM5J8M+GYI0odZ9gW" +
            "Q4UBG8LLcDql3JiIbV2IiU9xqGfTLxzhrdV/nNYTZ3BVDUGZBbcZoMk0yhVLZsvhVxvws2BWL53ytV//sYxSS0jvTYAv6CD54irA/GhfjnbaGdqgwtQRZzE+ro0nP9va" +
            "0xSzPQKBgQCIDEIOsKH2y7ZSV8yVH0ScdNBswgcUZOnZraO+FADnNkp4LzmEUWbUJ6Fml6z+rlLfwBIBGP5/JzAsGXC5P5Kn1CPfwcxQqRVPqP7YYJAppxoRqmPhTYnJ" +
            "P0P9hQDvp8yayj2ZgqJNCEx0crpLrEl7aH/hyk+q5CSRdzqKXjOfFwKBgDjEvs8jjSST/WA9HQY8GwpWJ1OD+Y644h3PDb6yywrHAvAr78xYCmEjLtq1g4ZSScNaVwpY" +
            "QWTo6pK15HBBs4DwK8luGNGVTmOS9Pks9TtubjeqjhyxJmrkZiANjQ1fB6fu0Z1PWGglLZ+6OUkvGgHwyexaua0ptgNVYY8T4OeG62c8ad0a15d9d1ca38d5dee762a16e01";
}
