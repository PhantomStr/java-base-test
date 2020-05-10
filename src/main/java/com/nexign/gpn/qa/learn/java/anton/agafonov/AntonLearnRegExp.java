package com.nexign.gpn.qa.learn.java.anton.agafonov;

import com.nexign.gpn.qa.learn.java.core.LearnRegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.RegExUtils.removeAll;

public class AntonLearnRegExp implements LearnRegExp {
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
        Pattern pattern = Pattern.compile("([^А-Яа-яёЁa-zA-Z]{10,})");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String g = matcher.group();
            g = removeAll(g, "[^\\d]");
            switch (g.length()) {
                case 10:
                    return formatPhoneNumber(g);
                case 11:
                    if (g.charAt(0) == '7' || g.charAt(0) == '8') {
                        return formatPhoneNumber(g.substring(1));
                    }

            }


        }
        return "";
    }

    private String formatPhoneNumber(String g) {

        return String.format("+7(%s)%s-%s-%s", g.substring(0, 3), g.substring(3, 6), g.substring(6, 8), g.substring(8, 10));
    }
}

