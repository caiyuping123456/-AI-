package org.example.utils;

import org.example.config.DateConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caiyuping
 * @date 2026/10/17 21:22
 * @description: 业务
 */
public class JDBCUtils {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DateConfig.getUrl(),DateConfig.getUsername(),DateConfig.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet!= null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement!= null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection!= null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Statement statement,Connection connection){
        close(null, statement, connection);
    }

    /**
     * 统一封装的增删改方法
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql,Object... params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setParams(preparedStatement,params);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(preparedStatement,connection);
        }
    }

    private static void setParams(PreparedStatement preparedStatement, Object... params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                try {
                    preparedStatement.setObject(i + 1, params[i]);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @FunctionalInterface
    public interface RowMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    public static<T> List<T> query(String sql,RowMapper<T> mapper, Object... params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> object = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setParams(preparedStatement,params);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                object.add(mapper.map(resultSet));
            }
            return object;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(resultSet,preparedStatement,connection);
        }
    }

}
