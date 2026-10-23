package org.example.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * department 部门表
 * department
 */
@Data
public class Department implements Serializable {
    /**
     * 部门ID
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门下的员工列表
     */
    private List<Employee> employees;

    private static final long serialVersionUID = 1L;
}