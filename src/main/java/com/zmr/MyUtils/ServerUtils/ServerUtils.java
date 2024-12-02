package com.zmr.MyUtils.ServerUtils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServerUtils {

    /**
     * <p> 获取服务名 </p>
     * @return
     */
    public static String getServerName() {
        String hostName = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            hostName = address.getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException("get server host failed.");
        }
        return hostName;
    }

    /**
     * <p> 获取服务全路径 </p>
     * @param request
     * @return
     */
    public static String getAllPath(HttpServletRequest request) {
        // ip and port information.
        String ip = request.getServerName();
        int port = request.getServerPort();
        // webAppName
        String webAppName = request.getContextPath();
        return String.format("%s:%s%s", ip, port, webAppName);
    }

    /**
     * <p> 获取服务 ID 后的最后一段路径 </p>
     * <p> example - "192.127.168.23" 会被截取成 23 </p>
     * @param request
     * @return
     */
    public static String getShortPath(HttpServletRequest request) {
        // ip and port information.
        String ip = request.getServerName();
        ip = ip.substring(ip.lastIndexOf(".") + 1);
        int port = request.getServerPort();
        // webAppName
        String webAppName = request.getContextPath();
        return String.format("%s:%s%s", ip, port, webAppName);
    }

    /**
     * <p> 获取到启动参数中 -DappName 的值 </p>
     * <p> 启动参数示例：java -DappName=MyApplication -jar target/myapp-1.0-SNAPSHOT.jar </p>
     * <p> 使用 System.getProperty("appName") 获取到对应的值 </p>
     * @return
     */
    public static String getAppName() {
        String appName = System.getProperty("appName");
        if (appName == null || "".equals(appName)) {
            return getServerName();
        }
        return appName;
    }
}
