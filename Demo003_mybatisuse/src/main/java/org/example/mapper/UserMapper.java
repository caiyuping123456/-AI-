package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.bean.Users;

/**
 * @author caiyuping
 * @date 2026/10/23 14:21
 * @description: 业务
 */
public interface UserMapper {
    Users getUserById(@Param("id") int id);
    int insertUser(@Param("user") Users user);
    int updateById(@Param("user") Users user);
    int deleteUsersById(@Param("id") int id);
}
