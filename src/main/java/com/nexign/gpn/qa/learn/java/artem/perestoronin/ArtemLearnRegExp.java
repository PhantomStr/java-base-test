package com.nexign.gpn.qa.learn.java.artem.perestoronin;

import com.nexign.gpn.qa.learn.java.LearnRegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.regex.Pattern.compile;

public class ArtemLearnRegExp implements LearnRegExp {

    /**
     * Получив строку, найти в ней номер телефона (может быть записан в любом формате)
     * 8**********
     * +7 *** *** ** **
     * **********
     * +8(***)***-**-**
     * и тд..
     * вернуть номер телефона в формате +7(***)***-**-**
     *
     * @param str В любой непонятной ситуации звони 800 555 353-5
     * @return +7(800)555-35-35
     */
    @Override
    public String findPhoneNumber(String str) {
        Pattern pattern = compile("\\d{10,11}");
        String filtered = str.replaceAll("[\\s-(),.\\[\\]{}]", "");
        Matcher matcher = pattern.matcher(filtered);
        while (matcher.find()) {
            String number = matcher.group();
            if (number.length() == 10) {
                return getFormat(number);
            } else {
                if (number.startsWith("7") || number.startsWith("8")) {
                    return getFormat(number.substring(1));
                }
            }
            matcher = pattern.matcher(filtered.substring(matcher.end()));
        }
        return "";
    }

    private String getFormat(String number) {
        String format = "+7(%s)%s-%s-%s";
        return format(format, number.substring(0, 3), number.substring(3, 6), number.substring(6, 8), number.substring(8));
    }

}
