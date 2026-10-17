package org.example.bean;

import org.example.a.SqlParamable;

import java.sql.Date;
import java.util.Objects;

/**
 * @author caiyuping
 * @date 2026/10/17 21:06
 * @description: 用户表
 */
public class Users implements SqlParamable {
    /**
     * 用户ID
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 年龄
     */
    private int age;
    /**
     * 创建时间
     */
    private Date createdAt;
    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && age == users.age && Objects.equals(username, users.username) && Objects.equals(email, users.email) && Objects.equals(createdAt, users.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, age, createdAt);
    }

    public Users(int id, String username, String email, int age, Date createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public Object[] toParams() {
        return new Object[]{username, email, age, createdAt};
    }
}
