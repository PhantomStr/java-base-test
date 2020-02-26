package com.nexign.gpn.qa.learn.java.dataprovider;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.Locale;

public class StringsDataProvider {

    @DataProvider
    public Object[][] names() {
        String name = new Faker(new Locale("ru-RU")).name().firstName();
        return new Object[][]{
                {name, name},
                {"", "незнакомец"},
                {" ", "незнакомец"},
                {"  ", "незнакомец"}, //<- неразрывные пробелы
                {null, "незнакомец"}

        };
    }

    @DataProvider
    public Object[][] atFirst() {
        return new Object[][]{
                {"", "@@"},
                {" ", " @"},
                {"@", "@@"},
                {"@@@", "@@"},
                {"@@@", "@@"},
                {"z", "z@"},
                {"zy", "zy"},
                {"zyx", "zy"},
                {"z@x", "z@"},
                {"z@x", "z@"},
                {null, "@@"},
        };
    }

    @DataProvider
    public Object[][] testZipZap() {
        return new Object[][]{
                {"zip", "zp"},
                {"zgp", "zp"},
                {"zipzip", "zpzp"},
                {"zip zap", "zp zp"},
                {"zip z zap", "zp z zp"},
                {"zip z p zap", "zp z p zp"},
                {"zp z zap", "zp z zp"},
                {"zp", "zp"},
                {"test", "test"},
                {"", ""},
                {null, ""},
        };
    }

}
