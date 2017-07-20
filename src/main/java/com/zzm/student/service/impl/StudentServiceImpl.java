package com.zzm.student.service.impl;

import com.zzm.student.dao.StudentDao;
import com.zzm.student.service.StudentService;
import com.zzm.student.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Integer add(StudentVo studentVo) {
        log.info(studentVo.toString());
        return studentDao.add(studentVo);
    }
}
