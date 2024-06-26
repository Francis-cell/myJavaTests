//package main.java.com.zmr.LearningFiles.BasicJava.requestBackendTests;
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
///**
// * @ClassName AESUtils
// * @Description AES加密处理手段
// * @Author zhumengren
// * @Date 2022/6/1 22:06
//
// * @Version 1.0
// **/
//public class AESUtils {
//    //使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
//    private static String KEY = "G1Edw76qBF04VHCQ";
//    private static String IV = "G1Edw76qBF04VHCQ";
//
//    /**
//     * 加密方法
//     * @param data  要加密的数据
//     * @param key 加密key
//     * @param iv 加密iv
//     * @return 加密的结果
//     * @throws Exception
//     */
//    public static String encrypt(String data, String key, String iv) throws Exception {
//        try {
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//"算法/模式/补码方式"
//            int blockSize = cipher.getBlockSize();
//
//            byte[] dataBytes = data.getBytes();
//            int plaintextLength = dataBytes.length;
//            if (plaintextLength % blockSize != 0) {
//                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
//            }
//
//            byte[] plaintext = new byte[plaintextLength];
//            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
//
//            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
//            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
//
//            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
//            byte[] encrypted = cipher.doFinal(plaintext);
//            return new Base64().encodeToString(encrypted).trim();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 解密方法
//     * @param data 要解密的数据
//     * @param key  解密key
//     * @param iv 解密iv
//     * @return 解密的结果
//     * @throws Exception
//     */
//    public static String desEncrypt(String data, String key, String iv) throws Exception {
//        try {
//            byte[] encrypted1 = new Base64().decode(data.trim().getBytes());
////            byte[] encrypted1 = Base64.getDecoder().decode(data.trim().getBytes());
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
//            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
//
//            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
//
//            byte[] original = cipher.doFinal(encrypted1);
//            return new String(original).trim();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 使用默认的key和iv加密
//     * @param data
//     * @return
//     * @throws Exception
//     */
//    public static String encrypt(String data) throws Exception {
//        return encrypt(data, KEY, IV);
//    }
//
//    /**
//     * 使用默认的key和iv解密
//     * @param data
//     * @return
//     * @throws Exception
//     */
//    public static String desEncrypt(String data) throws Exception {
//        return desEncrypt(data, KEY, IV);
//    }
//
//
//
//    /**
//     * 测试
//     */
//    public static void main(String args[]) throws Exception {
//
//        String test = "123";
//
//        String data = null;
//        String key = "G1Edw76qBF04VHCQ";
//        String iv = "G1Edw76qBF04VHCQ";
//
//        data = encrypt(test);
//
//        System.out.println(data);
//        System.out.println(desEncrypt(data));
////        System.out.println("html1: " + desEncrypt("Njc1QkYwMDQ1MDg4QzU1Rjg5RUY3QkUxNkM0QzZGRTk="));
////        System.out.println("html2: " + Base64.getEncoder().encodeToString("675BF0045088C55F89EF7BE16C4C6FE9".getBytes()).trim());
//    }
//}
