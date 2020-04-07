package com.nexign.gpn.qa.learn.java.patterns.behavioral.templatemethod.problem;

import java.io.File;
import java.io.IOException;

public class TemplateMethodMain {
    public static void main(String[] args) throws IOException {
        TxtPrinter txtPrinter = new TxtPrinter();
        txtPrinter.print(new File(TemplateMethodMain.class.getClassLoader().getResource("txt.txt").getFile()));

        PngPrinter pngPrinter = new PngPrinter();
        pngPrinter.print(new File(TemplateMethodMain.class.getClassLoader().getResource("img.png").getFile()));
    }
}
