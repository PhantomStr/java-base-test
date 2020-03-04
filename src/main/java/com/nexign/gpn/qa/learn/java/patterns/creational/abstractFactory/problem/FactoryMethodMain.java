package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.problem;

import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.problem.elfs.GreenDragon;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.problem.orcs.OrcArcher;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.problem.orcs.OrcSoldier;

public class FactoryMethodMain {

    public static void main(String[] args) {
        Squad squad = new Squad();
        squad.addArcher(new OrcArcher());
        squad.addSoldier(new OrcSoldier());
        squad.addDragon(new GreenDragon());
    }

}
