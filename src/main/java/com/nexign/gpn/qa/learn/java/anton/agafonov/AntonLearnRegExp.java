package com.nexign.gpn.qa.learn.java.anton.agafonov;

import com.nexign.gpn.qa.learn.java.core.LearnRegExp;

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
        return null;
    }

}
