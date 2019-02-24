package com.tian.controller;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.tian.dao.StudentMapper;
import com.tian.model.Student;
import com.tian.service.StudentService;
import com.tian.service.impl.StudentServiceImpl;
import com.tian.util.DateTime;
import com.tian.util.Page;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/student"})
public class StudentController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;


    /**
     * 模糊分页查询（全表和姓名模糊查询）
     * @param pageNum
     * @param name
     * @param request
     * @return
     */
    @RequestMapping(value = {"/listStudent"},
            method = {RequestMethod.GET}
    )
    public String selectStudentByName(Integer pageNum,String name,HttpServletRequest request){
        log.info(name);
        Map<String,Object> map = new HashMap <String, Object>();
        if("".equals(name)){
            map.put("name","");
        }else{
            map.put("name", name);
        }
        log.info(name);
        if (pageNum == null ){
            pageNum = 1;
        }
        log.info("====================目前pagenum为"+pageNum);

        Page page = new Page(pageNum,5,studentService.total(map));
        map.put("page",page);
        if (page.getPageNum() <= 0 ){
            pageNum = 1;
        }
        if(pageNum > page.getTotalPages()){
            pageNum = page.getTotalPages();
        }

        log.info("============page.getTotalPages is"+ page.getTotalPages()+ "pageNum is " + pageNum);


        page = new Page(pageNum,5,studentService.total(map));
        map.put("page",page);
        log.info(""+map);
        List<Student> namestudents = studentService.selectStudentByName(map);
        log.info(""+namestudents);
        request.setAttribute("students",namestudents);
        request.setAttribute("page",page);
        request.setAttribute("name",name);
        return "listStu";
    }

    /**
     * 新增学生
     * @param student
     * @return
     * @throws Exception
     */
   @RequestMapping(
            value = {"/student"},
        method = {RequestMethod.POST}
    )
    public ModelAndView insertStudent(Student student) throws Exception{
        log.info(""+student);
        student.setEstimatedTime(DateTime.getDateTime());
        student.setCreatedAt(DateTime.getTime());
        student.setUpdatedAt(DateTime.getTime());
        studentService.insertStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("a",student);
        modelAndView.setViewName("redirect:/student/listStudent");
        return modelAndView;

    }


    @RequestMapping(
            value = {"/student"},
            method = {RequestMethod.GET})
    public ModelAndView get() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addStudent");
        return modelAndView;

    }


    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.DELETE}
    )
    public ModelAndView deleteStudentByid(@PathVariable Integer id) {
        log.info("delete student id is "+ id);
        studentService.deleteStudentById(id);
        //servlet重定向默认是服务端跳转（forward），这里使用redirect客户端重定向
        ModelAndView modelAndView = new ModelAndView("redirect:/student/listStudent");
        return modelAndView;
    }


    /**
     * 根据id修改学生修真类型和辅导师兄
     * @param student
     * @return
     */
    @RequestMapping(
            value = {"/astudent"},
            method = {RequestMethod.PUT}
    )
    private ModelAndView updateStudentById(Student student) {

        log.info("update student id is "+ student.getId() +" type is "+student.getType() + " senior is "+ student.getSenior() +"upaete time is " + student.getUpdatedAt());        Boolean update = false;

        student.setUpdatedAt(DateTime.getTime());
        studentService.updateStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("b",student);
        modelAndView.addObject("msgs","name.is.null");

        modelAndView.setViewName("redirect:/student/listStudent");
        return modelAndView;

    }

    //跳转修改页面
    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.GET})
    public ModelAndView getUpdate(@PathVariable Integer id) throws Exception{
        //页面回显
        Student student = studentService.selectStudentById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("c",student);
        modelAndView.setViewName("updateStudent");
        return modelAndView;

    }
}