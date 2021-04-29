package com.invankharytanovich.springmvc.service;

import com.invankharytanovich.springmvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public void deleteEmployeeById(int id);
}
