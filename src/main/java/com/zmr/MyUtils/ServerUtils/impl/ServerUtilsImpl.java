package com.zmr.MyUtils.ServerUtils.impl;

import com.zmr.MyUtils.ServerUtils.ServerUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServerUtilsImpl implements ServerUtils {

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getServerName() {
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
     * {@inheritDoc}
     * @param request
     * @return
     */
    @Override
    public String getAllPath(HttpServletRequest request) {
        // ip and port information.
        String ip = request.getServerName();
        int port = request.getServerPort();
        // webAppName
        String webAppName = request.getContextPath();
        return String.format("%s:%s%s", ip, port, webAppName);
    }

    /**
     * {@inheritDoc}
     * @param request
     * @return
     */
    @Override
    public String getShortPath(HttpServletRequest request) {
        // ip and port information.
        String ip = request.getServerName();
        ip = ip.substring(ip.lastIndexOf(".") + 1);
        int port = request.getServerPort();
        // webAppName
        String webAppName = request.getContextPath();
        return String.format("%s:%s%s", ip, port, webAppName);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public String getAppName() {
        String appName = System.getProperty("appName");
        if (appName == null || "".equals(appName)) {
            return getServerName();
        }
        return appName;
    }
}
