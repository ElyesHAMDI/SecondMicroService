package com.exemple.seceond.core.domain.entitiesDto;



public class EmployeeDetailDto {

    private Long id;

    private String email;
    private String address;
    private String phone;
    private String hireDate;



    public EmployeeDetailDto() {}

    public EmployeeDetailDto(String email, String address, String phone, String hireDate) {
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.hireDate = hireDate;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getHireDate() { return hireDate; }

    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }
}
