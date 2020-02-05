package com.nexign.gpn.qa.learn.java.dataprovider;

import org.testng.annotations.DataProvider;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DateTimeDataProvider {

    @DataProvider
    public Object[][] zoneIdOf() {
        return new Object[][]{
                {"Europe/Moscow", "莫斯科时间"},
                {"Europe/London", "英国时间"},
                {"UTC", "协调世界时间"}
        };
    }

    @DataProvider
    public Object[][] systemClock() {
        return new Object[][]{
                {getRandomZoneIdName()},
                {"Europe/Moscow"},
                {"Australia/Sydney"},
                {"UTC"}
        };
    }

    @DataProvider
    public Object[][] localDateAtZone() {
        return new Object[][]{
                {"Australia/Sydney", 11},
                {"UTC", 0},
                {"America/Costa_Rica", -6},
        };
    }

    private String getRandomZoneIdName() {
        List<String> ids = new ArrayList<>(ZoneId.getAvailableZoneIds());
        return ids.get(new Random().nextInt(ids.size() - 1));
    }

}
