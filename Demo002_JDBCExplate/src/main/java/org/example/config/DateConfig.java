package org.example.config;

/**
 * @author caiyuping
 * @date 2026/10/17 21:19
 * @description: 数据库配置表
 */
public class DateConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/mysqldemo?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "20031217";

    public static String getUrl() {
        return URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

}
