package com.zzm.qrcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author kris
 * @Description:
 * @date 2017年11月07日 13:11
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        // 根据清算日查普表符合信息记录
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String date = LocalDate.now().format(formatter);

        String fileName = "AI0001" + date.replace("-", "") + ".txt";
        File reconciliationFile = new File(fileName);

        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(reconciliationFile));
            printStream.println("");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream;

        try

        {
            ftpClient.connect("10.0.37.109");
            ftpClient.login("banker", "banker");
            fileInputStream = new FileInputStream(reconciliationFile);
            ftpClient.storeFile("/" + "Bank_log" + "/" + reconciliationFile.getName(), fileInputStream);

            reconciliationFile.deleteOnExit();

        } catch (IOException e)

        {
            log.info(e.getMessage(), e);
            throw new RuntimeException("FTP客户端出错！", e);
        }
    }
}
