package com.nexign.gpn.qa.learn.java.anna.khvorostyanova;

import com.nexign.gpn.qa.learn.java.LearnDateTime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AnyutaLearnDateTime implements LearnDateTime {
    /**
     * Получив имя временной зоны вернуть ZoneId данной зоны.
     *
     * @param zoneName Europe/Moscow
     * @return ZoneId зоны Europe/Moscow.
     */
    @Override
    public ZoneId zoneIdOf(String zoneName) {
        return ZoneId.of(zoneName);
    }
    /**
     * Получив имя временной зоны вернуть системные часы в данной временной зоны.
     *
     * @param zoneName Australia/Sydney
     * @return Clock зоны Australia/Sydney;
     */
    @Override
    public Clock systemClock(String zoneName) {
        return Clock.system(zoneIdOf(zoneName));
        //:D не зря ж писали
    }
    /**
     * Получив имя временной зоны, создать текущий LocalDateTime
     * и вернуть соответствующий LocalDateTime для полученной зоны в  формате "yyyy-MM-dd'T'HH:mm:ss" c округлением времени до целых минут
     *
     * @param zoneName UTC
     * @return текущий LocalDateTime для зоны UTC.
     */
    @Override
    public String localDateAtZone(String zoneName) {
        //с точки зрения математики это не совсем верно, непонятно по постановке
        return LocalDateTime.now(systemClock(zoneName))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:00"));
    }
}
