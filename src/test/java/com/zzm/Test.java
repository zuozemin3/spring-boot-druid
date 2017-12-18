package com.zzm;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

/**
 * @author kris
 * @Description:
 * @date 2017年11月08日 16:17
 */
public class Test {
    public static void main(String[] args) {
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
            ftpClient.connect("10.37.144.177");
            //ftpClient.enterLocalPassiveMode();
            ftpClient.login("banker", "banker");
            fileInputStream = new FileInputStream(reconciliationFile);
            ftpClient.storeFile("/" + "Bank_log" + "/" + reconciliationFile.getName(), fileInputStream);

            reconciliationFile.deleteOnExit();

        } catch (IOException e) {
            throw new RuntimeException("FTP客户端出错！", e);
        }
    }
}
