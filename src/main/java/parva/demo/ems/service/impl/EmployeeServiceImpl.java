package parva.demo.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import parva.demo.ems.dto.EmployeeDto;
import parva.demo.ems.entity.Employee;
import parva.demo.ems.exception.ResourceNotFoundException;
import parva.demo.ems.mapper.EmployeeMapper;
import parva.demo.ems.repository.EmployeeRepository;
import parva.demo.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto creatEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not assist with given id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());

	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

		employeeRepository.deleteById(employeeId);

	}

}
