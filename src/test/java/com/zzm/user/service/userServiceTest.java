package com.zzm.user.service;

import com.zzm.user.service.UserService;
import com.zzm.user.vo.UserVo;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Data
public class userServiceTest {

  @Autowired
  private UserService userService;

  @Test
  @Rollback(value = false)
  public void saveUser() {
    UserVo userVo = new UserVo();
    userVo.setUserName("李四");
    System.out.println(userService.add(userVo));
  }

}
