package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author caiyuping
 * @date 2026/10/23 14:28
 * @description: 这个是Mybatis的工具类
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String configResource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(configResource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话，同时默认手动提交
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 获取会话，同时可以设置是否自动提交
     * @param autoCommit
     * @return
     */
    public static SqlSession getSqlSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }
}
