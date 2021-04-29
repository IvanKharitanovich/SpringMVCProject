package com.invankharytanovich.springmvc.dao;

import com.invankharytanovich.springmvc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployee();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public void deleteEmployeeById(int id);
}
