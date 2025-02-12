package com.exemple.seceond.adapter.client;

import com.exemple.seceond.core.domain.entitiesDto.EmployeeDetailDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "employee-service", url = "http://localhost:8081")
public interface EmployeeDetailsClient {

    @GetMapping("/api/users/employees/details/{id}")
    Optional<EmployeeDetailDto> getEmployeeDetails(@PathVariable("id") Long employeeId);

    @GetMapping("/api/users/employees/details")
    List<EmployeeDetailDto> getEllEmployeeDetails();

    @PostMapping("/api/users/employees/details")
    EmployeeDetailDto saveDetails(@RequestBody EmployeeDetailDto employeeDetailDto);

    @PutMapping("/api/users/employees/details/{id}")
    EmployeeDetailDto update(@RequestBody EmployeeDetailDto employeeDetailDto, @PathVariable("id") Long id);

    @DeleteMapping("/api/users/employees/details/{id}")
    void deleteById(@PathVariable("id") Long id);
}
