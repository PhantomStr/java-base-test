package com.nexign.gpn.qa.learn.java;

import com.nexign.gpn.qa.learn.java.core.LearnRegExp;
import com.nexign.gpn.qa.learn.java.dataprovider.RegExpDataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class LearnRegExpTest extends AbstractTest<LearnRegExp> {

    @Test(dataProvider = "findPhoneNumber", dataProviderClass = RegExpDataProvider.class)
    void findPhoneNumber(String str, String expected) {
        assertThat(testedClass.findPhoneNumber(str)).isEqualTo(expected);
    }

}
