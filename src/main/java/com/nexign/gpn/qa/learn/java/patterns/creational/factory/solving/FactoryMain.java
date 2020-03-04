package com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving;


import com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.pizza.SimplePizzaFactory;
import com.nexign.gpn.qa.learn.java.patterns.creational.factory.solving.store.PizzaStore;

public class FactoryMain {
    public static void main(String[] args) {
        PizzaFactory factory = new SimplePizzaFactory();
        // в другой реализации мы можем не создавать свою пиццу, а перезаказывать в соседнем магазине :)
        // Главная мысль - фабрика является единственным поставщиком пиццы для всего приложения
        PizzaStore orderPizza = new PizzaStore(factory);

        orderPizza.orderPizza("cheese");
        orderPizza.orderPizza("pepperoni");
    }

}
