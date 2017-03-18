package com.ycw.photosystem.tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WaterMark {


    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        }


    public static void main(String[] args) throws IOException {

        File file = new File("e:\\picture\\5.jpg");
        File wmFile = new File("e:\\picture\\WM5.png");
        Image image = ImageIO.read(file);
        BufferedImage bufferedImage = ImageIO.read(file);
        String format = "JPEG";
        printText(image, bufferedImage, "北邮档案", image.getWidth(null) / 4, image.getHeight(null) / 2);
        ImageIO.write(bufferedImage, format, wmFile);
    }

    public static void printText(Image srcImg, BufferedImage buffImg,
                                 String logoText, Integer positionX, Integer PositionY) {
        Graphics2D g = buffImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(
                srcImg.getScaledInstance(srcImg.getWidth(null),
                        srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
        g.setColor(Color.GRAY);
        g.setFont(new Font("宋体", Font.PLAIN, positionX / 2));
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.drawString(logoText, positionX, PositionY);
        g.dispose();
    }
}
