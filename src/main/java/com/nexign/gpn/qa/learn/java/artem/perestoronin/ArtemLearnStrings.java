package com.nexign.gpn.qa.learn.java.artem.perestoronin;

import com.nexign.gpn.qa.learn.java.LearnStrings;
import org.apache.commons.lang3.RegExUtils;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.rightPad;

public class ArtemLearnStrings implements LearnStrings {

    /**
     * Дано имя, например «Боб», верните приветствие в форме «Привет, Боб!».
     * Если имя не получено, то вернуть «Привет, незнакомец!»
     *
     * @param name Боб
     * @return Привет, Боб!
     */
    @Override
    public String helloName(String name) {
        return format("Привет, %s!", defaultIfBlank(name, "незнакомец"));
    }

    /**
     * Получив строку, верните строку длиной 2 из первых двух символов.
     * Если длина строки меньше 2, используйте '@' для пропущенных символов.
     *
     * @param str строка
     * @return ст
     */
    @Override
    public String atFirst(String str) {
        return rightPad(defaultString(str, ""), 2, '@').substring(0, 2);
    }

    /**
     * Найдите в строке такие шаблоны, как «zip» и «zap» - длина-3, начиная с «z» и заканчивая «p».
     * Вернуть строку, в которой для всех таких слов средняя буква отсутствует, поэтому «zipXzap» выдает «zpXzp».
     *
     * @param str zipXzap
     * @return zpXzp
     */
    @Override
    public String zipZap(String str) {
        return RegExUtils.replacePattern(defaultString(str, ""), "z.p", "zp");
    }

}
