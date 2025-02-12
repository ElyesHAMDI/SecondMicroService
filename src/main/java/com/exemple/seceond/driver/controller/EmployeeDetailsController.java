package com.exemple.seceond.driver.controller;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.exemple.seceond.core.domain.entitiesDto.EmployeeDetailDto;
import com.exemple.seceond.core.usecase.EmployeeDetailsUseCase;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/users")
public class EmployeeDetailsController {

@Autowired
private EmployeeDetailsUseCase employeeDetailsUseCase;

@GetMapping("/employees/details")
  public ResponseEntity<List<EmployeeDetailDto>> getAllemplyeesDetail() {

  System.out.println("getEllEmployeeDetails alldetails=  ");

  List<EmployeeDetailDto> employeesDetail = employeeDetailsUseCase.getAllDetails().stream()
            .map(employee -> new EmployeeDetailDto(employee.getEmail(), employee.getAddress(), employee.getPhone(), employee.getHireDate() ))
            .collect(Collectors.toList());

    return ResponseEntity.ok(employeesDetail);
  }

  @PostMapping("/employees/details")
  public ResponseEntity<EmployeeDetailDto> addNewEmployee(@RequestBody EmployeeDetailDto employeeDetailDto) {
    System.out.println("employeeDetail id=  "+employeeDetailDto.getId());
  EmployeeDetailDto createdEmployee = employeeDetailsUseCase.saveDetails(employeeDetailDto);

    // Convertir Employee en EmployeeDto
    //EmployeeDto employeeDto = new EmployeeDto(createdEmployee.getName(), createdEmployee.getRole());

    // Retourner une reponse avec un statut 201 et l'URI de la ressource creee
    return ResponseEntity
            .created(URI.create("/employees/" + createdEmployee.getEmail()))
            .body(createdEmployee);
  }

  @GetMapping("/employees/details/{id}")
  public ResponseEntity<EmployeeDetailDto> getOneEmployeeDetail(@PathVariable Long id) {
    System.out.println("getOneEmployeeDetail id=  "+id);

    Optional<EmployeeDetailDto> employee = employeeDetailsUseCase.getDetails(id);

    return employee.map(emp -> ResponseEntity.ok(emp))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }



  @PutMapping("/employees/details/{id}")
  ResponseEntity<EmployeeDetailDto> updateEmployee(@RequestBody EmployeeDetailDto newEmployee, @PathVariable Long id) {

    EmployeeDetailDto createdEmployee = employeeDetailsUseCase.update(newEmployee, id);

    //EmployeeDetailDto employeeDto = new EmployeeDto(createdEmployee.getName(), createdEmployee.getRole());

    return ResponseEntity
            .created(URI.create("/employees/" + createdEmployee.getEmail()))
            .body(createdEmployee);
  }

  @DeleteMapping("/employees/details/{id}")
  ResponseEntity<EmployeeDetailDto> deleteEmployee(@PathVariable Long id) {
    employeeDetailsUseCase.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}