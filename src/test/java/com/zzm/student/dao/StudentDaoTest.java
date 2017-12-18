package com.zzm.student.dao;

import com.zzm.student.vo.StudentVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void findAll() {
        List<StudentVo> studentVoList = studentDao.findAll();

        Assert.assertEquals(studentVoList.size(), 27);
    }
}
