package org.example.dao;

import org.example.pojo.Users;
import org.example.utils.JDBCUtils;

import java.util.List;

/**
 * @author caiyuping
 * @date 2026/10/17 21:56
 * @description: 用户的DAO
 */
public class UserDAO {
    /**
     * 添加用户
     * @param users
     */
    public void addUser(Users users){
        String sql = "insert into users(username,email,age,created_at) values(?,?,?,?)";
        int result = JDBCUtils.executeUpdate(sql,users.toParams());
        if (result > 0) {
            System.out.println("添加用户成功");
        } else {
            System.out.println("添加用户失败");
        }
    }

    /**
     * 用户更新
     * @param sql
     * @param params
     */
    public void updateUser(String sql,Object... params){
        int result = JDBCUtils.executeUpdate(sql,params);
        if (result > 0) {
            System.out.println("更新用户成功");
        } else {
            System.out.println("更新用户失败");
        }
    }

    /**
     * 用户删除
     * @param userId
     */
    public void deleteUser(int userId){
        String sql = "delete from users where id = ?";
        int result = JDBCUtils.executeUpdate(sql,Integer.valueOf(userId));
        if (result > 0) {
            System.out.println("删除用户成功");
        } else {
            System.out.println("删除用户失败");
        }
    }

    /**
     * 查询全部用户
     * @return
     */
    public List<Users> getAllUsers(){
        String sql = "select * from users";
        return JDBCUtils.query(sql, mapper -> {
            Users users = new Users();
            users.setId(mapper.getInt("id"));
            users.setUsername(mapper.getString("username"));
            users.setAge(mapper.getInt("age"));
            users.setEmail(mapper.getString("email"));
            users.setCreatedAt(mapper.getDate("created_at"));
            return users;
        });
    }

    /**
     * 查询指定条件的用户
     * @param sql
     * @param params
     * @return
     */
    public List<Users> getUsersByCondition(String sql, Object... params){
        return JDBCUtils.query(sql, mapper -> {
            Users users = new Users();
            users.setId(mapper.getInt("id"));
            users.setUsername(mapper.getString("username"));
            users.setAge(mapper.getInt("age"));
            users.setEmail(mapper.getString("email"));
            users.setCreatedAt(mapper.getDate("created_at"));
            return users;
        }, params);
    }

    /**
     * 查询一个用户
     * @param sql
     * @param params
     * @return
     */
    public Users getUserById(String sql,Object... params){
        List<Users> usersList = JDBCUtils.query(sql, mapper -> {
            Users users = new Users();
            users.setId(mapper.getInt("id"));
            users.setUsername(mapper.getString("username"));
            users.setAge(mapper.getInt("age"));
            users.setEmail(mapper.getString("email"));
            users.setCreatedAt(mapper.getDate("created_at"));
            return users;
        }, params);
        if (usersList.isEmpty()) {
            return null;
        } else {
            return usersList.get(0);
        }
    }


}
