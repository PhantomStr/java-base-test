package com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem;

import com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem.store.PizzaStore;

public class FactoryMethodMain {
    public static void main(String[] args) {
        PizzaStore orderPizza = new PizzaStore();
        orderPizza.orderPizza("cheese");
        orderPizza.orderPizza("pepperoni");
    }

}
