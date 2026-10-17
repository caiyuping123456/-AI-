package org.example;

import org.example.dao.UserDAO;
import org.example.pojo.Users;

import java.sql.Date;
import java.util.List;

/**
 * @author caiyuping
 * @date 2026/10/17 22:13
 * @description: 业务
 */
public class Main {
    public static void main(String[] args) {
        test01();
        System.out.println("===========================");
        test02();
        System.out.println("===========================");
        test03();
        System.out.println("===========================");
//        test04();
        System.out.println("===========================");
        test05();
        System.out.println("===========================");
        test06();
        System.out.println("===========================");
    }

    private static void test06() {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(5);
    }

    private static void test05() {
        UserDAO userDAO = new UserDAO();
        String sql = "update users set username = ? where id = ?";
        userDAO.updateUser(sql,"李四",1);

    }

    private static void test04() {
        UserDAO userDAO = new UserDAO();
        Users users = new Users();
        users.setAge(44);
        users.setCreatedAt(Date.valueOf("2026-10-17"));
        users.setUsername("张三");
        users.setEmail("12312121212");
        userDAO.addUser(users);

    }

    private static void test03() {
        UserDAO userDAO = new UserDAO();
        String sql = "select * from users where id = ?";
        Users userById = userDAO.getUserById(sql, 1);
        System.out.println(userById);
    }

    private static void test02() {
        UserDAO userDAO = new UserDAO();
        String sql = "select * from users where age > ?";
        List<Users> usersByCondition = userDAO.getUsersByCondition(sql, 27);
        for (Users users : usersByCondition) {
            System.out.println(users);
        }
    }

    public static void test01(){
        UserDAO userDAO = new UserDAO();
        List<Users> allUsers = userDAO.getAllUsers();
        for (Users users : allUsers) {
            System.out.println(users);
        }
    }
}
