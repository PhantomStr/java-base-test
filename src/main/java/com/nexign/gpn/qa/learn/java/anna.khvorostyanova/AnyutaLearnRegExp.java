package com.nexign.gpn.qa.learn.java.anna.khvorostyanova;

import com.nexign.gpn.qa.learn.java.LearnRegExp;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnyutaLearnRegExp implements LearnRegExp {
    /**
     * Получив строку, найти в ней номер телефона российских операторов (начинается с 8 или +7)
     * Номер может быть записан в любом формате, префикс страны так же может отсутствовать: 8**********, +7 *** *** ** **, **********, +8(***)***-**-** и тд..
     * <p>
     * Вернуть номер телефона в формате +7(***)***-**-**
     *
     * @param str В любой непонятной ситуации звони 800 555 353-5
     * @return +7(800)555-35-35
     */
    @Override
    public String findPhoneNumber(String str) {
        String phone = "";
        ArrayList<String> arr = new ArrayList<>();
        String newStr = str.replaceAll("[^a-zA-ZА-Яа-я0-9]", "");
        Pattern pattern = Pattern.compile("([78]?[34[8-9]]([0-9]{9}))");
        Matcher matcher = pattern.matcher(newStr);
        //по-любому можно упростить и жить без двух циклов
        while (matcher.find()) {
            arr.add(matcher.group());
        }
        for (String el:arr) {
            if (el.length()==11) {
                phone = makeMyPhoneFormat(StringUtils.substring(el, 1));
            }
            else if (el.length()==10) {
                phone = makeMyPhoneFormat(el);
            }
        }
        return phone;
}
//можно через printf или String.format, но уже не было сил думать :)
    private  String makeMyPhoneFormat(String str){

        return new StringBuilder(str)
                .insert(0, "+7(")
                .insert(6,")")
                .insert(10,"-")
                .insert(13, "-").toString();
    }
}
