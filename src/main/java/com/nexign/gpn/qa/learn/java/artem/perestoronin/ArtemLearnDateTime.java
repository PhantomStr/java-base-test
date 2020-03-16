package com.nexign.gpn.qa.learn.java.artem.perestoronin;

import com.nexign.gpn.qa.learn.java.core.LearnDateTime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.LocalDateTime.now;
import static java.time.ZoneId.systemDefault;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.temporal.ChronoUnit.MINUTES;

public class ArtemLearnDateTime implements LearnDateTime {

    /**
     * Получив имя временной зоны вернуть ZoneId данной зоны.
     *
     * @param zoneName Europe/Moscow
     * @return Объект ZoneId нужной зоны.
     */
    @Override
    public ZoneId zoneIdOf(String zoneName) {
        return ZoneId.of(zoneName);
    }

    /**
     * Получив имя временной зоны вернуть системные часы в данной временной зоны.
     * Подробней: https://www.baeldung.com/java-clock
     *
     * @param zoneName Australia/Sydney
     * @return Clock зоны Australia/Sydney;
     */
    @Override
    public Clock systemClock(String zoneName) {
        return Clock.system(ZoneId.of(zoneName));
    }

    /**
     * Получив имя временной зоны, создать текущий LocalDateTime и вернуть соответствующий LocalDateTime для полученной зоны.
     *
     * @param zoneName UTC
     * @return текущий LocalDateTime для зоны UTC.
     */
    @Override
    public String localDateAtZone(String zoneName) {
        return LocalDateTime.ofInstant(now().atZone(systemDefault()).toInstant(), ZoneId.of(zoneName))
                .truncatedTo(MINUTES)
                .format(ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

}
