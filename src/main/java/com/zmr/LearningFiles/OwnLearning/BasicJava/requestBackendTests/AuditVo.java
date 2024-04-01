//package main.java.com.zmr.LearningFiles.BasicJava.requestBackendTests;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//
///**
// * @ClassName AuditVo
// * @Description 加密处理account和一个自己设置的值的方式
// * @Author zhumengren
// * @Date 2022/6/1 22:26
//
// * @Version 1.0
// **/
//public class AuditVo {
//    /** 账户名称 */
//    private String account;
//    /** 一个必须传输的字段 */
//    private String auditNo;
//    /** 当下时间 */
//    private long nowTime;
//    /** 过期时间 */
//    private long expireTime;
//
//    public AuditVo() {
//    }
//
//    public AuditVo(String account, String auditNo, long nowTime, long expireTime) {
//        this.account = account;
//        this.auditNo = auditNo;
//        this.nowTime = nowTime;
//        this.expireTime = expireTime;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getAuditNo() {
//        return auditNo;
//    }
//
//    public void setAuditNo(String auditNo) {
//        this.auditNo = auditNo;
//    }
//
//    public long getNowTime() {
//        return nowTime;
//    }
//
//    public void setNowTime(long nowTime) {
//        this.nowTime = nowTime;
//    }
//
//    public long getExpireTime() {
//        return expireTime;
//    }
//
//    public void setExpireTime(long expireTime) {
//        this.expireTime = expireTime;
//    }
//
//    /**
//     * url编码（目的是解决get请求过程中对特殊字符截断的问题处理）
//     * @param str 需要进行编码的字符串的值
//     * @return String
//     */
//    private static String encodeUri(String str) throws UnsupportedEncodingException {
//        return URLEncoder.encode(str,"UTF-8").replace("+", "%20");
//    }
//
//    /**
//     * url解码
//     * @param str 需要进行解码的字符串的值
//     * @return String
//     */
//    private static String decodeUri(String str) throws UnsupportedEncodingException {
//        return URLEncoder.encode(str,"UTF-8");
//    }
//
//    /**
//     * 设置默认十分钟的有效时间 (  加密  )
//     * @param account account信息
//     * @param auditNo 外一个一并要加密的字段信息
//     * @return String
//     */
//    public static String build(String account, String auditNo) throws Exception {
//        return build(account, auditNo, 600000);
//    }
//
//    /**
//     * 自定义有效时间，毫秒  (  加密  )
//     * @param account account信息
//     * @param auditNo 另外一个一并要加密的字段信息
//     * @param expireTime 自定义有效时间，ms
//     * @return String
//     */
//    public static String build(String account, String auditNo, long expireTime) throws Exception {
//        AuditVo auditVo = new AuditVo();
//        auditVo.setAccount(account);
//        auditVo.setAuditNo(auditNo);
//        auditVo.setExpireTime(expireTime);
//        // 设置当前时间的值
//        auditVo.setNowTime(System.currentTimeMillis());
//        // 返回加密之后再进行编码处理的加密信息的值
//        return encodeUri(AESUtils.encrypt(JSON.toJSONString(auditNo)));
//    }
//
//
//    /**
//     * 解密方方法
//     * @param aesAccount 加密之后的account信息的值
//     * @return AuditVo
//     */
//    public static AuditVo parseAuditVo(String aesAccount) throws Exception {
//        // 检查account信息是否为空
//        //if (StringUtils.isEmpty(account)) {
//        //    throw new BusinessException("account信息为空");
//        //}
//        if (aesAccount.equals("")) {
//            System.out.println("account信息为空！需要进行异常处理!!!");
//        }
//        String json = AESUtils.desEncrypt(aesAccount);
//        return JSON.parseObject(json, new TypeReference<AuditVo>(){});
//    }
//
//    /**
//     * 校验是否超过了有效时间
//     * @param
//     * @return void
//     */
//    public void validExpireTime() {
//        // 获取当前的时间
//        long now = System.currentTimeMillis();
//        // 获取时间差
//        long difTime = now - this.nowTime;
//        // 判断是否超时
//        if (difTime > expireTime) {
//            //throw new BusinessException("链接已过期，请重新访问!");
//            System.out.println("链接已过期，请重新访问!需要进行异常处理!!! ");
//        }
//    }
//}
