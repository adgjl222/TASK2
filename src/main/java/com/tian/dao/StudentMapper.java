package com.tian.dao;

import com.tian.model.Student;

import java.util.List;
import com.tian.util.Page;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository//spring中的注解 用于标注dao组件
public interface StudentMapper {
        int insertStudent(Student student);

        int updateStudent(Student student);


        int deleteStudentById(Integer id);


        List<Student> selectAll();

        //根据分页查询数据
        List<Student> list(Map<String,Object> map);

        //查询总行数
        int total(Map<String,Object> map);

        List<Student> selectStudentByName(Map<String,Object> map);


        Student selectStudentById(Integer id);
}

