
import com.tian.dao.StudentMapper;
import com.tian.model.Student;
import com.tian.service.StudentService;
import com.tian.util.DateTime;
import com.tian.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)//为了让测试在Spring容器环境下执行
@ContextConfiguration({"classpath:spring-mybatis.xml"})// 加载spring配置文件
public class StudentDaoTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(StudentService.class);

    @Resource
    private StudentMapper studentDao;
    @Resource
    private StudentService studentService;


    @Test
    public void testSelectStudentById()throws Exception{
        Integer id = 1333734;
        log.info("===================="+id);
        Student student = studentService.selectStudentById(id);
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
        Page page = new Page(1,5,studentDao.total());
        map.put("page",page);
        log.info(""+map);

        List<Student>  list = studentService.selectStudentByName(map);

        log.info(""+list);

        log.info("get student list BeginRownumis "+page.getBeginRownum()+" pageRows is "+page.getPageRows()+" get result size is " +list.size());

    }


    @Test
    public void testTotal()throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        int total = studentDao.total();
        log.info(""+total);
    }


/*    *//**
     * 分页查询
     *//*
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


    }*/



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

    @Test
    public void testAop(){
        Integer id = 45;
        System.out.println(studentService.deleteStudentById(id));
    }

    @Test
    public void testSpringMessage(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 获取MessageSource的Bean
        MessageSource messageSource = ctx.getBean("resource",MessageSource.class);

        //new GregorianCalendar().getTime() 当我们想要能够人为社会定时间时，就需要用到GregorianCalendar类
        Object[ ] objects = {"fanbingbibng",new GregorianCalendar().getTime()};



        String msg1 = messageSource.getMessage("greeting.common",objects,Locale.CHINESE);

        String msg2 = messageSource.getMessage("greeting.morning",objects,Locale.US);

        String msg3 = messageSource.getMessage("greeting.afternoon",objects,Locale.CHINESE);

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);


    }

    }