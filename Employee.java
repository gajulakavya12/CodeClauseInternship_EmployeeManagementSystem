package com.CodeClause.EMS.model;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private double salary;
    private Date joinDate;

    public Employee() {}

    public Employee(int id, String name, String email, String phone,
                    String department, double salary, Date joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }

    @Override
    public String toString() {
        return "Employee [id=" + id +
               ", name=" + name +
               ", email=" + email +
               ", phone=" + phone +
               ", department=" + department +
               ", salary=" + salary +
               ", joinDate=" + joinDate + "]";
    }
}

