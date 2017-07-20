package com.zzm.user.service;

import com.zzm.user.vo.UserVo;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Data
public class userServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    @Rollback
    public void saveUser() {
        UserVo userVo = new UserVo();
        userVo.setUserName("李四");
        userVo.setUserAge(18);
        userService.add(userVo);
    }

}
