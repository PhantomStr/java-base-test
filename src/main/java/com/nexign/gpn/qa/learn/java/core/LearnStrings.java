package com.nexign.gpn.qa.learn.java.core;

/**
 * для более продуктивного времяпрепровождения рекомендуется изучить {@link org.apache.commons.lang3.StringUtils} и {@link org.apache.commons.lang3.RegExUtils}
 */
public interface LearnStrings {

    /**
     * Дано имя, например «Боб», верните приветствие в форме «Привет, Боб!».
     * Если имя не получено, то вернуть «Привет, незнакомец!»
     *
     * @param name Боб
     * @return Привет, Боб!
     */
    String helloName(String name);

    /**
     * Получив строку, верните строку длиной 2 из первых двух символов.
     * Если длина строки меньше 2, используйте '@' для пропущенных символов.
     *
     * @param str строка
     * @return ст
     * null -> "@@"
     */
    String atFirst(String str);

    /**
     * Найдите в строке такие шаблоны, как «zip» и «zap» - длина-3, начиная с «z» и заканчивая «p».
     * Вернуть строку, в которой для всех таких слов средняя буква отсутствует, поэтому «zipXzap» выдает «zpXzp».
     *
     * @param str zipXzap
     * @return zpXzp
     * null -> ""
     */
    String zipZap(String str);

}
