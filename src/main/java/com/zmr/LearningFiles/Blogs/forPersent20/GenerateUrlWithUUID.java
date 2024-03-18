package com.zmr.LearningFiles.Blogs.forPersent20;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

public class GenerateUrlWithUUID {
    /**
     * 将要被处理的内容和 UUID 拼接在一块儿
     * @param content 要和 UUID 一块儿进行加密处理的内容
     * @return
     */
    public static String generateContent(String content) {
        // 1、随机出 UUID 的值
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String uuidString = uuid.toString();
        String tmpContent = content + "-" + uuidString;

        // 2、将 UUID 进行 url 编码
        String ans;
        try {
            ans = URLEncoder.encode(content, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            // 处理异常情况
            throw new RuntimeException(e);
        }

        return ans;
    }

    public static void main(String[] args) {
        String baseUrl = "https://example.com/resource?a=";
        String content = "小黑";
        String ansUrl = baseUrl + generateContent(content);
        System.out.println("最终生成的 URL 的值为：" + ansUrl);
    }
}
