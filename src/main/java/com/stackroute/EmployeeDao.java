package com.stackroute;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  //Logic for insert statement
  public int insertEmployee(Employee employee)
  {
    String query= "insert into employee values('"+employee.getEmployeeId()+"','"+employee.getEmployeeName()+"','"+employee.getEmployeeAge()+"',' "+employee.getGender()+" ')";
    return jdbcTemplate.update(query);
  }
  //Logic for Update statement
  public void updateEmployee(Integer employeeId, Integer employeeAge, String employeeName){
    String SQL = "update employee set Age = ?, Name = ? where Id = ?";
    jdbcTemplate.update(SQL, employeeAge,employeeName, employeeId);
    System.out.println("Updated Record with ID = " + employeeId );
  }
  //Logic for delete operation
  public int deleteEmployee(Employee employee)
  {
    String query="delete from employee where Id='"+employee.getEmployeeId()+"' ";
    return jdbcTemplate.update(query);
  }
  //Logic for select operation
  public List<Employee> retriveEmployees(){
    String query="select * from employee";
    final List<Employee> list = new ArrayList<Employee>();
    return jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>(){
        @Override
        public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
          while (resultSet.next()) {
            Employee e = new Employee();
            e.setEmployeeId(resultSet.getInt(1));
            e.setEmployeeName(resultSet.getString(2));
            e.setEmployeeAge(resultSet.getInt(3));
            e.setGender(resultSet.getString(4));
            list.add(e);
          }
          return list;
        }
      }
    );
  }
}
