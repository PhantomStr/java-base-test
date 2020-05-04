package com.nexign.gpn.qa.learn.java.anton.agafonov;

import com.nexign.gpn.qa.learn.java.core.LearnStrings;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
import static org.apache.commons.lang3.StringUtils.normalizeSpace;
import static org.apache.commons.lang3.StringUtils.replaceAll;

/**
 * для более продуктивного времяпрепровождения рекомендуется изучить {@link org.apache.commons.lang3.StringUtils} и {@link org.apache.commons.lang3.RegExUtils}
 */
public class AntonLearnStrings implements LearnStrings {

    /**
     * Дано имя, например «Боб», верните приветствие в форме «Привет, Боб!».
     * Если имя не получено, то вернуть «Привет, незнакомец!»
     *
     * @param name Боб
     * @return Привет, Боб!
     */
    @Override
    public String helloName(String name) {

        if (name == null || normalizeSpace(name).equals("")) {
            return "Привет, незнакомец!";
        }
        return "Привет, " + name + "!";
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
        if (str == null) {
            return "@@";
        }

        switch (str.length()){
            case 0:
                return "@@";
            case 1:
                return str.substring(0,1) + "@";
            default:
                return str.substring(0,2);
        }
    }

    /**
     * Найдите в строке такие шаблоны, как «zip» и «zap» - длина-3, начиная с «z» и заканчивая «p».
     * Вернуть строку, в которой для всех таких слов средняя буква отсутствует, поэтому «zipXzap» выдает «zpXzp».
     *
     * @param str zipXzap
     * @return zpXzp
     * null -> ""
     */
    @Override
    public String zipZap(String str) {

        return replaceAll(defaultIfNull(str,""),"[zZ]\\S[Pp]","zp");
    }

}
