package com.api_nov.service;

import com.api_nov.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto add(EmployeeDto employeeDto);
    public void deleteEmployee(long id);
    public EmployeeDto findEmployeeById(long id);
    public void updateEmployee(long id,EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployee(int pageNO, int pageSize, String sortBy);

}
