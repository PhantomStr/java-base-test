package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.army.factory;

import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Archer;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Dragon;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Soldier;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.orcs.OrcArcher;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.orcs.OrcSoldier;

public class OrcFractionArmyFactory implements AbstractFractionArmyFactory {


    @Override
    public Archer getArcher() {
        return new OrcArcher();
    }

    @Override
    public Soldier getSoldier() {
        return new OrcSoldier();
    }

    @Override
    public Dragon getDragon() {
        return null;
    }

}
