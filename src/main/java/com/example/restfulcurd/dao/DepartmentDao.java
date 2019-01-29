package com.example.restfulcurd.dao;

import com.example.restfulcurd.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

        departments.put(001,new Department(001,"FF-ONE"));
        departments.put(002,new Department(002,"FF-TWO"));
        departments.put(003,new Department(003,"FF-THR"));
        departments.put(004,new Department(004,"FF-FOU"));
        departments.put(005,new Department(005,"FF-FIV"));
    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
