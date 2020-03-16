package com.nexign.gpn.qa.learn.java.core;


import java.time.Clock;
import java.time.ZoneId;

/**
 * В Java 8 DateTime API реализовано множество классов и методов, которые существенно упрощают работу со временем и датами.({@link java.time})
 * <p>
 * <a href="https://jon.com.ua/blog/vvedenie-v-rabotu-s-datoj-i-vremenem-v-java-8/">Хорошая статья для понимания.</a>
 */
public interface LearnDateTime {

    /**
     * Получив имя временной зоны вернуть ZoneId данной зоны.
     *
     * @param zoneName Europe/Moscow
     * @return ZoneId зоны Europe/Moscow.
     */
    ZoneId zoneIdOf(String zoneName);

    /**
     * Получив имя временной зоны вернуть системные часы в данной временной зоны.
     *
     * @param zoneName Australia/Sydney
     * @return Clock зоны Australia/Sydney;
     */
    Clock systemClock(String zoneName);

    /**
     * Получив имя временной зоны, создать текущий LocalDateTime
     * и вернуть соответствующий LocalDateTime для полученной зоны в  формате "yyyy-MM-dd'T'HH:mm:ss" c округлением времени до целых минут
     *
     * @param zoneName UTC
     * @return текущий LocalDateTime для зоны UTC.
     */
    String localDateAtZone(String zoneName);

}
