package com.zzm.user.dao;

import com.zzm.user.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Ignore
    @Test
    public void findAll() {
        List<UserVo> userVoList = userDao.findAll();

        Assert.assertEquals(userVoList.size(), 2);
    }


    @Ignore
    @Test
    public void test() {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream;
        String pathName = "AI000120171109.txt";
        File reconciliationFile = new File(pathName);

        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(reconciliationFile));
            printStream.println("eeeeee");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ftpClient.connect("10.0.37.109");
            ftpClient.enterLocalPassiveMode();
            ftpClient.login("banker", "banker");
            fileInputStream = new FileInputStream(reconciliationFile);
            ftpClient.storeFile("/" + "Bank_log" + "/" + reconciliationFile.getName(), fileInputStream);

            reconciliationFile.deleteOnExit();

        } catch (IOException e) {
            log.info(e.getMessage(), e);
            throw new RuntimeException("FTP客户端出错！", e);
        }
    }
}
