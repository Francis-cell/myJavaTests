package com.zmr.MyUtils.ServerUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 获取应用 ID 和服务器名 </p>
 */
public interface ServerUtils {
    /**
     * <p> 获取服务名 </p>
     * @return
     */
    String getServerName();

    /**
     * <p> 获取服务全路径 </p>
     * @param request
     * @return
     */
    String getAllPath(HttpServletRequest request);

    /**
     * <p> 获取服务 ID 后的最后一段路径 </p>
     * <p> example - "192.127.168.23" 会被截取成 23 </p>
     * @param request
     * @return
     */
    String getShortPath(HttpServletRequest request);

    /**
     * <p> 获取到启动参数中 -DappName 的值 </p>
     * <p> 启动参数示例：java -DappName=MyApplication -jar target/myapp-1.0-SNAPSHOT.jar </p>
     * <p> 使用 System.getProperty("appName") 获取到对应的值 </p>
     * @return
     */
    String getAppName();
}
