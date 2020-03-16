package com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.pizza;

import com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.PizzaFactory;

public class SimplePizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
