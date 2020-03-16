package com.nexign.gpn.qa.learn.java.anna.khvorostyanova;

import com.nexign.gpn.qa.learn.java.core.LearnStrings;
import org.apache.commons.lang3.StringUtils;

public class AnyutaLearnStrings implements LearnStrings {
    @Override
    public String helloName(String name) {
        return String.format("Привет, %s!", StringUtils.defaultIfBlank(StringUtils.normalizeSpace(name), "незнакомец"));
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
        if (str == null || str.equals("")) return "@@";
        int len = str.length();
        if (len >= 2) return str.substring(0, 2);
        else return str + "@";
    }

    @Override
    public String zipZap(String str) {
        String pattern = "z[a-zA-z]p";
        return StringUtils.defaultIfBlank(str, "").replaceAll(pattern, "zp");
    }

}
