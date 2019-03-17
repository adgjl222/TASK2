package com.tian.service;

import com.tian.model.Student;
import com.tian.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Student selectStudentById(Integer id);

    List<Student> selectStudentByName(Map<String,Object> map);
/*
    List<Student> selectAll();*/

    //获取表中总行数
    int total();

/*    //根据分页来查询数据
    List<Student> list(Map<String,Object> map);*/

    Boolean deleteStudentById(Integer id);

    Boolean updateStudent(Student student);

    int insertStudent(Student student);


}