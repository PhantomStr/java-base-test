package com.nexign.gpn.qa.learn.java;

import com.nexign.gpn.qa.learn.java.dataprovider.StringsDataProvider;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class LearnStringsTest extends AbstractTest<com.nexign.gpn.qa.learn.java.LearnStrings> {

    @Test(dataProvider = "names", dataProviderClass = StringsDataProvider.class)
    void helloName(String name, String expected) {
        assertThat(testedClass.helloName(name)).isEqualTo(format("Привет, %s!", expected));
    }

    @Test(dataProvider = "atFirst", dataProviderClass = StringsDataProvider.class)
    public void atFirst(String word, String expected) {
        assertThat(testedClass.atFirst(word)).isEqualTo(expected);
    }

    @Test(dataProvider = "testZipZap", dataProviderClass = StringsDataProvider.class)
    public void testZipZap(String zipZap, String expected) {
        assertThat(testedClass.zipZap(zipZap)).isEqualTo(expected);
    }

}
