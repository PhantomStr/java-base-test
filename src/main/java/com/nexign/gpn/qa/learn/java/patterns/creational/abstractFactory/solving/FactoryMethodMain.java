package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving;


import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.army.factory.ElfFractionArmyFactory;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.army.factory.OrcFractionArmyFactory;


public class FactoryMethodMain {
    public static void main(String[] args) {
        Squad elfSquad = new SquadCreator(new ElfFractionArmyFactory()).getSquad();
        Squad orcSquad = new SquadCreator(new OrcFractionArmyFactory()).getSquad();
    }

}
