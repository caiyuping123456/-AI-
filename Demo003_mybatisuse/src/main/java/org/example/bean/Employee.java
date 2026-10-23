package org.example.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * employee 员工表
 * employee
 */
@Data
//使用二级缓存，要进行类的序列化
public class Employee implements Serializable {
    /**
     * 员工ID
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 多对一
     */
    private Department department;

    private static final long serialVersionUID = 1L;
}