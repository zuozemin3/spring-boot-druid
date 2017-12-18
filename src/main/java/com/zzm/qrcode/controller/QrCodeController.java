package com.zzm.qrcode.controller;

import com.zzm.qrcode.QRCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kris
 */

@Api(description = "扫码接口")
@RestController
public class QrCodeController {

    @ApiOperation(value = "获取二维码")
    @RequestMapping(value = "/qrCode",method = RequestMethod.GET)
    public void qrCode(String content, @RequestParam(defaultValue = "500", required = false) int width, @RequestParam(defaultValue = "500", required = false) int height, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            QRCodeUtil.writeToStream(content, outputStream, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
