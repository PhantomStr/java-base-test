package com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving;

import com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.pizza.Pizza;

public interface PizzaFactory {
    Pizza createPizza(String type);

}
