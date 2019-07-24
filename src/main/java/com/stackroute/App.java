package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        //Inserting values into the Employee table
        EmployeeDao dao=applicationContext.getBean("edao",EmployeeDao.class);
        int status=dao.insertEmployee(new Employee(103,"Asmitha",22,"female"));
        System.out.println(status);
        //Updating the Employee table
        System.out.println("----Updating Record with ID -----" );
        dao.updateEmployee(102, 35,"praveen");
        //Performing delete operation
        System.out.println("delete");
        Employee e=new Employee();
        e.setEmployeeId(12);
        status=dao.deleteEmployee(e);
        System.out.println(status);
        //Performing select query
        System.out.println("select query");
        List<Employee> list=dao.retriveEmployees();
        for(Employee e1:list)
            System.out.println(e1);
    }
}
