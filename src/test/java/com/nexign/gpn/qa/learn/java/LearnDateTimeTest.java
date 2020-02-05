package com.nexign.gpn.qa.learn.java;

import com.nexign.gpn.qa.learn.java.dataprovider.DateTimeDataProvider;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class LearnDateTimeTest extends AbstractTest<LearnDateTime> {

    @Test(dataProvider = "zoneIdOf", dataProviderClass = DateTimeDataProvider.class)
    public void zoneIdOf(String zoneName, String expected) {
        assertThat(testedClass.zoneIdOf(zoneName).getDisplayName(TextStyle.FULL, Locale.CHINA)).isEqualTo(expected);
    }

    @Test(dataProvider = "systemClock", dataProviderClass = DateTimeDataProvider.class)
    public void systemClock(String zoneName) {
        assertThat(testedClass.systemClock(zoneName).getZone().getDisplayName(TextStyle.NARROW, Locale.ENGLISH)).isEqualTo(zoneName);
    }

    @Test(dataProvider = "localDateAtZone", dataProviderClass = DateTimeDataProvider.class)
    public void localDateAtZone(String zoneName, int dif) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:00");
        dif -= parseInt(StringUtils.substring(ZoneId.systemDefault().getRules().toString(), -7, -4));
        Pattern compile = Pattern.compile(dif > 0 ? now().plusHours(dif).format(formatter) : now().minusHours(-dif).format(formatter));
        String actual = testedClass.localDateAtZone(zoneName);
        assertThat(actual).matches(compile);
    }

}