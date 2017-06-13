package com.zzm.student.service.impl;

import com.zzm.student.dao.StudentDao;
import com.zzm.student.service.StudentService;
import com.zzm.student.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDao studentDao;

  @Override
  public Integer add(StudentVo studentVo) {
    return studentDao.add(studentVo);
  }
}
