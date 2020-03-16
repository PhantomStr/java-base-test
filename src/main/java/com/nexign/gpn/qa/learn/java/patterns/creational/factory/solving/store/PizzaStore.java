package com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.store;

import com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.PizzaFactory;
import com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PizzaStore {
    PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
