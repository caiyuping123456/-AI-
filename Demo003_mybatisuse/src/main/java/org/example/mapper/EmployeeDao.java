package org.example.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.example.bean.Department;
import org.example.bean.Employee;

public interface EmployeeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    /**
     * 多对一
     * @param id
     * @return
     */
    Employee getEmpAndDeptById(@Param("id") int id);

    /**
     * 部门Id
     * @param DeptId
     * @return
     */
    Department getDeptAndEmpById(@Param("DeptId") int DeptId);
}