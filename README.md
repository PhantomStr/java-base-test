# Проект для проверки знаний по основам java
С вопросами, предложениями, ошибками писать Artem.Perestoronin@nexign.com

## Рекомендации к прохождению
1. Прочитать Обязательный минимум https://confluence-gpn.nexign.com/pages/viewpage.action?pageId=9801449
2. При имплементации классов заданий выделить галочку "Copy JavaDoc"  
3. Внимательно читать описания методов и классов заданий.
4. Выполнять проще в следующем порядке:
    * LearnStrings
    * LearnArrays
    * LearnRegExp
    * LearnCollections
    * LearnDateTime


## Как проходить тесты
1. создать ветку из master ветки со своим именем и перейти на неё
2. создать в директории **src\main\java** в пакете **com.nexign.gpn.qa.learn.java** директорию со своим доменным именем (например artem.perestoronin) 
3. в этой директории создать классы имплементирующие классы заданий (com.nexign.gpn.qa.learn.java.Learn*)
4. создать в директории **src\test\java** в пакете **com.nexign.gpn.qa.learn.java** директорию со своим доменным именем (например artem.perestoronin)
5. в этой директории создать классы имплементирующие классы тестов (com.nexign.gpn.qa.learn.java.Learn*Test)
6. в getTestedClass вернуть новый экземпляр вашего класса
```java
package com.nexign.gpn.qa.learn.java.artem.perestoronin;

import com.nexign.gpn.qa.learn.java.LearnArrays;
import com.nexign.gpn.qa.learn.java.LearnArraysTest;

public class ArtemLearnArraysTest extends LearnArraysTest {

    @Override
    protected LearnArrays getTestedClass() {
        return new ArtemLearnArrays();
    }

}
```
7. решить задания и выполнить тесты.
8. создать пул-реквест в мастер-ветку 
