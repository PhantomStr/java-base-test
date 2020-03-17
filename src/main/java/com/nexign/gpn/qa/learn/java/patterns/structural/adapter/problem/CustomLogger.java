package com.nexign.gpn.qa.learn.java.patterns.structural.adapter.problem;

//интерфейс адаптируемого объекта
public interface CustomLogger {
    public void logInfo(String message);

    public void logWarn(String message);

    public void logError(String message);

}
