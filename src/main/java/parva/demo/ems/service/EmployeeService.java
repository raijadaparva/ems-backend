package parva.demo.ems.service;

import java.util.List;

import parva.demo.ems.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto creatEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatEmployeeDto);

	void deleteEmployee(Long employeeId);
}
