package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.bean.Users;
import org.example.mapper.UserMapper;
import org.example.utils.MybatisUtil;

import java.sql.Date;

/**
 * @author caiyuping
 * @date 2026/10/23 14:35
 * @description: 业务
 */
public class Main {
    public static void main(String[] args) {
//        selectById();
//        insertUser();
//        updateUsersById();
        deleteUserById();
    }

    public static void selectById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users user = mapper.getUserById(2);
        System.out.println(user);
    }

    public static void insertUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users user = new Users();
        user.setUsername("林初榆");
        user.setAge(20);
        user.setEmail("linchuyu.gmail");
        user.setCreatedAt(new Date(System.currentTimeMillis()));
        int result = mapper.insertUser(user);
        sqlSession.commit();
        System.out.println(result);
    }

    public static void updateUsersById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users users = new Users();
        users.setEmail("linchuyu@gmail");
        users.setAge(18);
        users.setId(8);
        int i = mapper.updateById(users);
        sqlSession.commit();
        System.out.println(i);
    }

    public static void deleteUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUsersById(8);
        sqlSession.commit();
        System.out.println(result==1?"删除成功":"删除失败");

    }
}
