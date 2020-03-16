package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.army.factory;

import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Archer;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Dragon;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Soldier;

public interface AbstractFractionArmyFactory {
    Archer getArcher();

    Soldier getSoldier();

    Dragon getDragon();

}
