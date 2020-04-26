package com.example.lovecode.service;

import com.example.lovecode.annotation.TestAnnotation;
import com.example.lovecode.common.Constants;
import com.example.lovecode.jdbc.mybatis.Entity.UserEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

@Service
public class CodeService {

    @Autowired
    private RedisService redisService;

    public byte[] genarate(String message) {
        UserEntity userEntity = new UserEntity("name");
        if (!StringUtils.isEmpty(message)) {
            if (redisService.getValue(message) != null) {
                System.out.println("缓存中获得" + redisService.getValue(message));
                return (byte[])redisService.getValue(message);
            }
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            try {
                BitMatrix bitMatrix = qrCodeWriter.encode(message, BarcodeFormat.QR_CODE, Constants.QRCODE_WIDTH, Constants.QRCODE_HEIGHT);
                // 1、读取文件转换为字节数组
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                BufferedImage image = toBufferedImage(bitMatrix);
                //转换成png格式的IO流
                ImageIO.write(image, "jpg", out);
                byte[] bytes = out.toByteArray();
                InputStream in = new ByteArrayInputStream(bytes);
                BufferedImage im = null;
                try {
                    im = ImageIO.read(in);
                    ImageIO.write(im, "jpg", new File("D://"+"code"+".jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // 2、将字节数组转为二进制
                System.out.println("here$####");
                redisService.setValue(message, bytes);
                return bytes;
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * image流数据处理
     * @param matrix
     * @return
     */
    public BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
}
