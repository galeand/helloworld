package com.ele.helloword;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ele.helloword.bean.StudentInfo;
import com.ele.helloword.bean.User;
import com.ele.helloword.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureDataJdbc
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class HelloWordApplicationTests {

    @Test
    public void test02() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a == b);
        Float c = Float.valueOf(a);
        Float d = Float.valueOf(b);
        System.out.println(c.equals(d));
        Float e = new Float(1.0f - 0.9f);
        Float f = new Float(0.9f - 0.8f);
        System.out.println(e.equals(f));

        System.out.println("============");
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
    }

    @Test
    public void test03() {
//        orderList.stream().sorted(
//                Comparator.comparingLong(object -> Math.abs(getAddressOrder(object.getConsumerAddress()) - addressOrder))).collect(
//                Collectors.toList());

        List<StudentInfo> studentList = new ArrayList<>();
        //自然序排序一个list
        studentList.add(new StudentInfo("李小明", true, 18, 1.76, LocalDate.of(2001, 3, 23)));
        studentList.add(new StudentInfo("张小丽", false, 18, 1.61, LocalDate.of(2001, 6, 3)));
        studentList.add(new StudentInfo("王大朋", true, 19, 1.82, LocalDate.of(2000, 3, 11)));
        studentList.add(new StudentInfo("陈小跑", false, 17, 1.67, LocalDate.of(2002, 10, 18)));

        System.out.println("-------排序前------------");
        StudentInfo.printStudents(studentList);

        List<StudentInfo> sortedStudentList = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());

        System.out.println("-------按照年龄升序排序后-------------");
        StudentInfo.printStudents(sortedStudentList);

        System.out.println("-------按照年龄降序排序后-------------");
        List<StudentInfo> sortedStudentList2 = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed()).collect(Collectors.toList());
        StudentInfo.printStudents(sortedStudentList2);

        System.out.println("-------按照身高升序排序后-------------");
        List<StudentInfo> sortedStudentList3 = studentList.stream().sorted(Comparator.comparing(StudentInfo::getHeight)).collect(Collectors.toList());
        StudentInfo.printStudents(sortedStudentList3);

    }

    private void testSwitch(String param) {
        // switch首先会对传入的参数进行判空，所以在使用switch语句之后需要先判断这个传入的param是否为空
        switch (param) {
            case "null":
                System.out.println("It's null");
                break;
            case "1":
                System.out.println("It's one");
                break;
            default:
                System.out.println("default");

        }
    }

    @Test
    public void contextLoads() {
        SqlSession session = new SqlSessionFactoryBuilder()
                .build(
                        HelloWordApplicationTests.class.getClassLoader().getResourceAsStream("mybatis-config.xml"))
                .openSession();

        User user = new User("zhangsna", "1232", "13234329399", "北京市昌平区");
        UserDao userDao = session.getMapper(UserDao.class);

//        System.out.println(userDao.insertUser(user));
        User user1 = userDao.selectUser(1);
        System.out.println(user1.toString());

        session.commit();
    }

    /**
     * 获取当前时间的三种方式
     */
    @Test
    public void test01() {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));

        System.out.println(date.getTime());

        long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);

        Date date1 = new Date(timeStamp);
        System.out.println(date1);

        long timeStamp2 = new Date().getTime();
        System.out.println(timeStamp2);
    }

}
