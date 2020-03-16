package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving;

import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.army.factory.AbstractFractionArmyFactory;

public class SquadCreator {
    AbstractFractionArmyFactory factory;

    public SquadCreator(AbstractFractionArmyFactory factory) {
        this.factory = factory;
    }

    public Squad getSquad() {
        Squad squad = new Squad();
        squad.addArcher(factory.getArcher());
        squad.addSoldier(factory.getSoldier());
        squad.addDragon(factory.getDragon());
        return squad;
    }

}
