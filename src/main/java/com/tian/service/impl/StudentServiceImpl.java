package com.tian.service.impl;

import com.tian.dao.StudentMapper;
import com.tian.model.Student;
import com.tian.service.StudentService;

import com.tian.util.Page;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentDao;

    @Override
    public Student selectStudentById(Integer sId) {
        return this.studentDao.selectStudentById(sId);
    }

    @Override
    public List<Student> selectStudentByName(Map<String,Object> map) {
        return this.studentDao.selectStudentByName(map);
    }


    @Override
    public List <Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public int total(Map<String,Object> map) {
        return studentDao.total(map);
    }


    @Override
    public List <Student> list(Map<String,Object> map) {
        map.put("name","");
        Page page = new Page(1,5,studentDao.total(map));
        map.put("page",page);
        log.info("get student list  BeginRownum is "+page.getBeginRownum()+" pageRows is "+page.getPageRows()+" get map  is " +map);
        List<Student> lists= studentDao.list(map);

        log.info("get student list BeginRownumis "+page.getBeginRownum()+" pageRows is "+page.getPageRows()+" get result size is " +lists.size());

        return lists;

    }


    @Override
    public Boolean deleteStudentById(Integer id) {
        Boolean delete = false;
        int count = studentDao.deleteStudentById(id);
        if (count != 0){
            delete = true;
            log.info("学生注销"+delete);
        }else {
            log.info("学生注销"+delete);
        }
        return delete;
    }

    @Override
    public Boolean updateStudent(Student student) {

        log.info("update student id is "+ student.getId() +" type is "+ student.getType() + " senior is "+ student.getSenior() +"upaete time is " + student.getUpdatedAt());        Boolean update = false;
        int count = studentDao.updateStudent(student);
        if (count != 0){
            update = true;
            log.info("修改学生"+update);
        }else {
            log.info("修改学生"+update);
        }
        return update;
    }

    @Override
    public int insertStudent(Student student) {

        return this.studentDao.insertStudent(student);
    }


}