package com.exemple.seceond.core.usecase;

import com.exemple.seceond.adapter.client.EmployeeDetailsClient;
import com.exemple.seceond.core.domain.entitiesDto.EmployeeDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsUseCase {

    private final EmployeeDetailsClient employeeDetailsClient;

    @Autowired
    public EmployeeDetailsUseCase(EmployeeDetailsClient employeeDetailsClient) {
        this.employeeDetailsClient = employeeDetailsClient;
    }

    public Optional<EmployeeDetailDto> getDetails(Long id) {
        return employeeDetailsClient.getEmployeeDetails(id);
    }

    public List<EmployeeDetailDto> getAllDetails() {
        return employeeDetailsClient.getEllEmployeeDetails();
    }

    public EmployeeDetailDto saveDetails(EmployeeDetailDto employeeDetailDto) {
        return employeeDetailsClient.saveDetails(employeeDetailDto);
    }

    public EmployeeDetailDto update(EmployeeDetailDto employeeDetailDto, Long id) {
        return employeeDetailsClient.update(employeeDetailDto, id);
    }

    public void deleteById(Long id) {
        employeeDetailsClient.deleteById(id);
    }
}

