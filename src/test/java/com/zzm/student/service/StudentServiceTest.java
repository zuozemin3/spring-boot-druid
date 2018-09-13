package com.zzm.student.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import com.zzm.student.vo.StudentVo;
import org.junit.Ignore;
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

  @Ignore
  @Test
  public void addTest() {
    StudentVo studentVo = new StudentVo();
    studentVo.setName("王五");
    studentService.add(studentVo);
    assertThat(studentVo.getId(), greaterThan(1));
  }

}
