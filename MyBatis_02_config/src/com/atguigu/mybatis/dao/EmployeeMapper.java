package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

/**
 * @author jingming.wang
 * @date 2020/9/4-14:18
 */
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
