//package LearningFiles.UtilsUsing.javaMailUtils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//
///**
// * @ClassName SendMailUtils
// * @Description Java 邮件发送工具类
// * @Author zhumengren
// * @Date 2022/4/15 17:32
// * @Email zhumengren@sinosoft.com
// * @Version 1.0
// **/
//public class SendMailUtils {
//    private static final Logger logger = LoggerFactory.getLogger(SendMailUtils.class);
//
//    // 发件人邮箱地址
//    public static String myEmailAccount = "franciszmr@foxmail.com";
//    // 发件人邮箱密码(这里使用的是申请到的授权密码)
//    public static String myEmailPassword = "sgqwgygmuayrchca";
//    // 发件人使用的昵称信息
//    public static String myEmailNickName = "zmr";
//    // 发件人的SMTP服务器地址
//    public static String myEmailSMTPHost = "smtp.qq.com";
//
//    // 收件人邮箱
//    public static String receiveEmialAccount = "zhumengren@sinosoft.com.cn";
//
//
//    /**
//     * 生成一个需要发送的邮件(完整版)
//     * @return void
//     */
//    public static void createEmail() {
//        // 0、写入必要的参数
//        // 发送邮件的地址
//        String emailFromAddress = "emial@send.com";
//        // 接收邮件的地址
//        String emailToAddress = "my@receive.com";
//        // 发送邮件时使用的昵称
//        String nickName = "zmr";
//        // 发送邮件的主题
//        String emailObject = "邮件主题";
//        // 发送邮件的正文
//        String emailContent = "邮件正文：这是我的一个测试的邮件的内容";
//
//        // 1、创建一个邮件
//        // 用于连接邮件服务器的参数配置（发送邮件的时候要使用到）
//        Properties props = new Properties();
//        // 根据参数配置，创建会话对象（为了发送邮件准备的）
//        Session session = Session.getInstance(props);
//        // 创建邮件对象
//        MimeMessage message = new MimeMessage(session);
//
//        /*
//         * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
//         * 这里出现的myEmail.eml的这种以.eml结尾的文件格式应该就是邮件的文件
//         * MimeMessage message = new MimeMessage(session, new FileInputStream("myEmail.eml"));
//         */
//        try {
//            // 2、发件人设置
//            //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
//            //    真正要发送时, 邮箱必须是真实有效的邮箱。
//            message.setFrom(new InternetAddress(emailFromAddress, nickName, "UTF-8"));
//
//            // 3、收件人
//            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailToAddress, "USER_CC", "UTF-8"));
//            //    To: 增加收件人（可选）
//            //message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("XXX.com", "USER_DD", "UTF-8"));
//            //    Cc: 抄送（可选）
//            //message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("XXX.com", "USER_EE", "UTF-8"));
//            //    Bcc: 密送（可选）
//            //message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("XXX.com", "USER_FF", "UTF-8"));
//
//            // 4、Subject: 邮件主题
//            message.setSubject(emailObject, "UTF-8");
//
//            // 5、Content: 邮件正文(可以使用html标签)
//            message.setContent(emailContent, "text/html;charset=UTF-8");
//
//            // 6、设置显示的发件时间
//            message.setSentDate(new Date());
//
//            // 7、保存前面的设置
//            message.saveChanges();
//
//            // 8、将该邮件保存到本地
//            FileOutputStream out = new FileOutputStream("myEmail.eml");
//            message.writeTo(out);
//            out.flush();
//            out.close();
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            //logger.info("不支持的编码方式异常！");
//            System.out.println("不支持的编码方式异常！");
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            //logger.info("输出的文件位置有问题！");
//            System.out.println("输出的文件位置有问题！");
//            e.printStackTrace();
//        } catch (IOException e) {
//            //logger.info("IO异常！");
//            System.out.println("IO异常");
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 发送邮件
//     * @return void
//     */
//    public static void sendEmail() {
//        // 1、创建参数配置，用于连接邮件服务器的参数配置
//        // 参数配置
//        Properties props = new Properties();
//        // 使用的协议(JavaMail规范要求)
//        props.setProperty("mail.transport.protocol", "smtp");
//        // 发件人的邮箱的SMTP服务器地址
//        props.setProperty("mail.smtp.host", myEmailSMTPHost);
//        // 需要请求认证
//        props.setProperty("mail.smtp.auth", "true");
//
//        // SSL 安全连接
//        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
//        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
//        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
//        /*
//        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
//        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
//        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
//        final String smtpPort = "465";
//        props.setProperty("mail.smtp.port", smtpPort);
//        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");
//        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
//        */
//
//
//        // javax.mail.Session保存邮件系统的配置属性和提供用户验证的信息，发送email首先要获取session对象
//        /*
//         * Session.getInstance(props);        获取非共享的session对象
//         * Session.getDefaultInstance(props); 获取共享的session对象
//        */
//
//
//        // 2、根据配置创建会话对象，用于和邮件服务器进行交互
//        Session session = Session.getInstance(props);
//        // 设置为debug模式，可以查看到详细的发送日志
//        session.setDebug(true);
//
//
//        try {
//            // 3、创建一封邮件
//            MimeMessage message = createMimeMessage(session, myEmailAccount, receiveEmialAccount, myEmailNickName);
//
//            // 4、根据Session获取邮件传输对象
//            Transport transport = session.getTransport();
//
//            // 5、使用邮箱账号和密码连接邮件服务器，这里认证的邮箱必须与message中的发件人邮箱一致，否则报错
//
//            //    PS_01: 如果连接服务器失败, 都会在控制台输出相应失败原因的log。
//            //    仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接,
//            //    根据给出的错误类型到对应邮件服务器的帮助网站上查看具体失败原因。
//            //
//            //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
//            //           (1) 邮箱没有开启 SMTP 服务;
//            //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
//            //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
//            //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
//            //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
//            transport.connect(myEmailAccount, myEmailPassword);
//
//
//            // 6、发送邮件，发送到所有的收件地址，message.getAllRecipients()，获取到的是在创建邮件对象时添加的所有收件人，抄送人，密送人
//            transport.sendMessage(message, message.getAllRecipients());
//
//
//            // 7、关闭链接
//            transport.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 创建一个邮件文件(仅仅只包含简单文本的)
//     * @param session
//     * @param sendMail
//     * @param receiveMail
//     * @return MimeMessage
//     */
//    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String nickName) throws Exception {
//        // 1. 创建一封邮件
//        MimeMessage message = new MimeMessage(session);
//
//        // 2. From: 发件人
//        message.setFrom(new InternetAddress(sendMail, nickName, "UTF-8"));
//
//        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
//        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));
//
//        // 4. Subject: 邮件主题
//        message.setSubject("下班打卡提醒邮件", "UTF-8");
//
//        // 5. Content: 邮件正文（可以使用html标签）
//        message.setContent("已经6点了，准备打卡下班了！", "text/html;charset=UTF-8");
//        // 6. 设置发件时间
//        message.setSentDate(new Date());
//
//        // 7. 保存设置
//        message.saveChanges();
//
//        return message;
//    }
//}
