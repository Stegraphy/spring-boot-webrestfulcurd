package com.example.restfulcurd.cocntroller;

import com.example.restfulcurd.dao.DepartmentDao;
import com.example.restfulcurd.dao.EmployeeDao;
import com.example.restfulcurd.entities.Department;
import com.example.restfulcurd.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmplyeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认进行拼串
        //t通过application.properties中的spring.thymeleaf.cache定位到
        //public static final String DEFAULT_PREFIX = "classpath:/templates/";  XXX 。html    路径
        return "emp/list";
    }

    //访问员工添加页面
    @GetMapping("/emp")
    public String ToAddPage(Model model){
        //放回员工添加页面路径,并查询所有部分信息再显示在页面上
       Collection<Department> departments =  departmentDao.getDepartments();
       model.addAttribute("depts",departments);
        return "/emp/add";
    }

    //实现员工添加功能
    //SpringMVC自动将请求参数和入参对象进行一一绑定，：要求请求参数的名字要和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //System.out.println("保存的员工信息："+employee);  验证是否提交成功数据：注意birth的数据格式2019/2/8
        //保存提交的员工数据信息
        employeeDao.save(employee);
        //点击员工添加按钮后页面应该跳转到员工列表页面
        //redirect:表示重定向到一个地址   / 代表当前项目路径
        //forward:表示妆发到一个地址
        System.out.println(employee);
        return "redirect:/emps";
    }

    //来到修改页面，查出员工id，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //回到修改页面（add.html是一个修改添加的二合一页面
        return "emp/add";

    }

    //员工修改功能,需要提交员工的id
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";

    }

    //员工删除功能
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
