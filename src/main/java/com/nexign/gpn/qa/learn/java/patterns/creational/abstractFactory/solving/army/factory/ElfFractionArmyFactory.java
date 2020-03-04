package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.army.factory;

import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Archer;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Dragon;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.Soldier;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.elfs.ElfArcher;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.elfs.ElfSoldier;
import com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving.elfs.GreenDragon;

public class ElfFractionArmyFactory implements AbstractFractionArmyFactory {


    @Override
    public Archer getArcher() {
        return new ElfArcher();
    }

    @Override
    public Soldier getSoldier() {
        return new ElfSoldier();
    }

    @Override
    public Dragon getDragon() {
        return new GreenDragon();
    }

}
