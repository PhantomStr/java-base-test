package com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem.store;

import com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem.pizza.CheesePizza;
import com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem.pizza.PepperoniPizza;
import com.nexign.gpn.qa.learn.java.patterns.creational.factory.problem.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        // Нарушается принцип единной ответственности - метод отвечает не только за процесс
        // подготовки пиццы к отправке, но и за её создание
        // Если другому классу потребуется создать пиццу, придётся дублировать этот код и поддерживать
        // создание новых объектов и в других местах
        pizza.prepare();
        pizza.cut();
        pizza.box();
        return pizza;


    }

}
