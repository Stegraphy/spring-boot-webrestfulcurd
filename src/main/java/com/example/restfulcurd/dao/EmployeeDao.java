package com.example.restfulcurd.dao;

import com.example.restfulcurd.entities.Department;
import com.example.restfulcurd.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(001,new Employee(001,"EE-ONE","151@qq.com",1,new Department(001,"FF-ONE")));
        employees.put(001,new Employee(002,"EE-TWO","151@qq.com",0,new Department(002,"FF-TWO")));
        employees.put(001,new Employee(003,"EE-THR","151@qq.com",0,new Department(003,"FF-THR")));
        employees.put(001,new Employee(004,"EE-FOU","151@qq.com",0,new Department(004,"FF-FOU")));
        employees.put(001,new Employee(005,"EE-FIV","151@qq.com",1,new Department(005,"FF-FIV")));

    }
    private  static Integer InitId= 006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(InitId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询所有员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id){

        employees.remove(id);
    }
}
