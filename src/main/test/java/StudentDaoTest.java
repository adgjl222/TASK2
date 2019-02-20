
import com.tian.dao.StudentMapper;
import com.tian.model.Student;
import com.tian.service.StudentService;
import com.tian.util.DateTime;
import com.tian.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)//为了让测试在Spring容器环境下执行
@ContextConfiguration({"classpath:spring-mybatis.xml"})// 加载spring配置文件
public class StudentDaoTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudentDaoTest.class);

    @Resource
    private StudentMapper studentDao;
    @Resource
    private StudentService studentService;

    @Test
    public void testSelectStudentById()throws Exception{
        Integer id = 1;
        Student student = studentDao.selectStudentById(id);
        log.info(student.toString());
    }

    /**
     * 根据姓名模糊查询
     * @throws Exception
     */
    @Test
    public void testSelectStudentByName() throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        String name ="测";
        map.put("name",name);
        Page page = new Page(1,5,studentDao.total(map));
        map.put("page",page);
        log.info(""+map);

        List<Student>  list = studentService.selectStudentByName(map);

        log.info(""+list);

        log.info("get student list BeginRownumis "+page.getBeginRownum()+" pageRows is "+page.getPageRows()+" get result size is " +list.size());

    }


    @Test
    public void testTotal()throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        int total = studentDao.total(map);
        log.info(""+total);
    }


    /**
     * 分页查询
     */
    @Test
    public void testList()throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        String name = "";
        map.put("name",name);
        Page page = new Page(1,5,studentDao.total(map));
        map.put("page",page);
        log.info("get map  is " +map);
        List<Student> lists= studentDao.list(map);
        log.info(""+lists);
        log.info("get student list BeginRownumis "+page.getBeginRownum()+" pageRows is "+page.getPageRows()+" get result size is " +lists.size());


    }



    @Test
    public void testDeleteStudentById() throws Exception{
        Integer id = 1;
        log.info("delete student id is"+ id);
        studentService.deleteStudentById(id);

    }

    @Test
    public void testInsertStudent()throws Exception{
        Student student = new Student();
        student.setLineId(5689);
        student.setName("刘德华");
        student.setQq(65656565);
        student.setGraduateFrom("郑州大学");
        student.setKnowFrom("知乎");
        student.setLogUrl("http://www.jnshu.com/school/24388/daily?page=1&orderBy=3&sort=1");
        student.setType("java");
        student.setWill("宣言");
        student.setSenior("流");
        student.setEstimatedTime(DateTime.getDateTime());
        student.setCreatedAt(DateTime.getTime());
        log.info(""+student);
       int a =  studentService.insertStudent(student);
       log.info(""+a);
    }

    @Test
    public void testUpdateStudentById()throws Exception{
        Student student = new Student();
        student.setId(66);
        student.setType("ui");
        student.setSenior("冰冰");
        student.setUpdatedAt(DateTime.getTime());
        studentService.updateStudent(student);
    }
    }