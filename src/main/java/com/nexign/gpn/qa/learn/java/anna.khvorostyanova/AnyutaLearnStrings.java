package com.nexign.gpn.qa.learn.java.anna.khvorostyanova;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.RegExUtils.removeAll;

public class AnyutaLearnStrings implements com.nexign.gpn.qa.learn.java.LearnStrings {
    @Override
    public String helloName(String name) {
        return String.format("Привет, %s!",StringUtils.defaultIfBlank(removeAll(name,"[\\s\\u00A0\\t\\r]"), "незнакомец"));
        }


    /**
     * Получив строку, верните строку длиной 2 из первых двух символов.
     * Если длина строки меньше 2, используйте '@' для пропущенных символов.
     *
     * @param str строка
     * @return ст
     * null -> "@@"
     */
    @Override
    public String atFirst(String str) {
        if (str==null || str.equals("")) return "@@";
        int len = str.length();
        if (len >= 2) return str.substring(0, 2);
        else return str + "@";
    }

    @Override
    public String zipZap(String str) {
        String pattern = "z[a-zA-z]p";
        String trimmedString;
        if (str != null) {
            trimmedString = str.replaceAll(pattern, "zp");
        } else trimmedString="";
        return trimmedString;
    }
}
