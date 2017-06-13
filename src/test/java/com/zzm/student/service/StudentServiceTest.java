package com.zzm.student.service;

import com.zzm.student.vo.StudentVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class StudentServiceTest {

  @Autowired
  private StudentService studentService;

  @Test
  public void addTest() {
    StudentVo studentVo = new StudentVo();
    studentVo.setName("王五");
    studentService.add(studentVo);
    System.out.println(studentVo.getId());
  }

}
