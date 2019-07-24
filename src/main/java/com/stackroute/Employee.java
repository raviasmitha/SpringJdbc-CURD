package com.stackroute;

public class Employee {
  private int employeeId;
  private String employeeName;
  private int employeeAge;
  private String gender;
  //Employee parameteraised Constructor
  public Employee(int employeeId, String employeeName, int employeeAge, String gender) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.employeeAge = employeeAge;
    this.gender = gender;
  }
  //Employee Default constructor
  public Employee() {
  }


  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public int getEmployeeAge() {
    return employeeAge;
  }

  public void setEmployeeAge(int employeeAge) {
    this.employeeAge = employeeAge;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "employeeId=" + employeeId +
      ", employeeName='" + employeeName + '\'' +
      ", employeeAge=" + employeeAge +
      ", gender='" + gender + '\'' +
      '}';
  }
}

