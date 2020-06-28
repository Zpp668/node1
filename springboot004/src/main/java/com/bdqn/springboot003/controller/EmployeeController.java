package com.bdqn.springboot003.controller;

import com.bdqn.springboot003.dao.DepartmentDao;
import com.bdqn.springboot003.dao.EmployeeDao;
import com.bdqn.springboot003.entities.Department;
import com.bdqn.springboot003.entities.Employee;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    //查询所有员工，返回列表页面
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        //thymeleaf会自动拼接classpath:/templates/
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public  String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到添加页面
        return "emp/add";
    }
    @PostMapping("/emp")
    //springMVC自动将请求参数和入参对象的属性一一绑定，要求请求参数的名字和javabean入参的对象里面的属性名是一样的
    public String addEmp(Employee employee){
        System.out.println("保存员工的信息"+employee);
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect 重定向页面 /代表当前项目路径
        //forward  表示转发到一个地址
        return "redirect:/emps";
    }
    //来到修改页面，并通过id查询员工信息
    @GetMapping("emp/{id}")
    public String toEdiPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //获取部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/edit";
    }
    //修改员工信息，需要提交员工id
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //删除员工
    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
