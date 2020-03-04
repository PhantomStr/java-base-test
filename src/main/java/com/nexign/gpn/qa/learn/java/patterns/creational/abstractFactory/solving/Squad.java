package com.nexign.gpn.qa.learn.java.patterns.creational.abstractFactory.solving;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    List<Archer> archers = new ArrayList<>();
    List<Soldier> soldiers = new ArrayList<>();
    List<Dragon> dragons = new ArrayList<>();

    void addArcher(Archer archer) {
        archers.add(archer);
    }

    void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    void addDragon(Dragon dragon) {
        dragons.add(dragon);
    }

}
