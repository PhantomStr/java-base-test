package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.problem;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.testng.reporters.Files.readFile;

@Slf4j
public class PngPrinter {
    public void print(File pdf) throws IOException {
        String content = readFile(pdf);
        validate(content);
        OutputStream printer = getPrinter();
        byte[] bytes = convert(pdf);
        printer.write(bytes);
    }

    private byte[] convert(File file) throws IOException {
        return new Img2Ascii()
                .convertToAscii(new FileInputStream(file))
                .getBytes();
    }

    private OutputStream getPrinter() {
        return System.out;
    }

    private void validate(String content) {
        log.info("validate png file");
    }

    private static class Img2Ascii {

        public String convertToAscii(FileInputStream fileInputStream) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedImage img = ImageIO.read(fileInputStream);

            double pixval;
            for (int i = 0; i < img.getHeight(); i += 4) {
                for (int j = 0; j < img.getWidth(); j += 2) {
                    Color pixcol = new Color(img.getRGB(j, i));
                    pixval = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol
                            .getGreen() * 0.11)));

                    stringBuilder.append(strChar(pixval));
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }

        public String strChar(double g) {
            String str;
            if (g >= 240) {
                str = " ";
            } else if (g >= 210) {
                str = ".";
            } else if (g >= 190) {
                str = "*";
            } else if (g >= 170) {
                str = "+";
            } else if (g >= 120) {
                str = "^";
            } else if (g >= 110) {
                str = "&";
            } else if (g >= 80) {
                str = "8";
            } else if (g >= 60) {
                str = "#";
            } else {
                str = "@";
            }
            return str;
        }

    }

}
