package com.nexign.gpn.qa.learn.java.patterns.behavioral.state.problem;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(of = {"count", "state"})
public class GumballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_COIN = 1;
    final static int HAS_COIN = 2;
    final static int SOLD = 3;
    int count;
    private int state = SOLD_OUT;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_COIN;
        }
    }

    public void insertCoin() {
        switch (state) {
            case HAS_COIN:
                log.warn("Монетка уже вставлена!");
                return;
            case NO_COIN:
                log.info("Монетка принята");
                state = HAS_COIN;
                return;
            case SOLD_OUT:
                log.warn("Все шарики проданы, монетка не принимается");
                return;
            case SOLD:
                log.warn("Пожалуйста, подождите, шарик выдаётся");
        }
    }

    public void ejectCoin() {
        switch (state) {
            case HAS_COIN:
                log.info("Возврат монетки");
                state = NO_COIN;
                return;
            case NO_COIN:
            case SOLD_OUT:
                log.warn("Вы не всталяли монетку");
                return;
            case SOLD:
                log.warn("Извините, вы уже дёрнули рычаг");
        }
    }

    public void turnCrank() {
        switch (state) {
            case HAS_COIN:
                log.info("Рычаг нажат");
                state = SOLD;
                dispense();
                return;
            case SOLD_OUT:
                log.warn("Все шарики проданы! И вообще, хотя бы монетку попытайся вставить (нет)");
                return;
            case SOLD:
            case NO_COIN:
                log.warn("Вставьте монетку!");
        }
    }

    public void dispense() {
        switch (state) {
            case HAS_COIN:
                log.error("Как ты вызвал выдачу шарика не дёрнув рычаг? Хацкер что-ли?");
                return;
            case NO_COIN:
                log.warn("Вставьте монетку и дёрните рычаг!");
                return;
            case SOLD_OUT:
                log.error("Шарики закончились, кто-то тут неудачник ААХАХАХА!");
                return;
            case SOLD:
                log.info("Шарик выдан");
                count = count - 1;
                if (count == 0) {
                    state = SOLD_OUT;
                } else {
                    state = NO_COIN;
                }
        }
    }

    public void refill(int count) {
        this.count += count;
        if (count > 0) {
            state = NO_COIN;
        } else {
            state = SOLD_OUT;
        }
    }

    public void logState() {
        log.info("---\n{}\n---", this);
    }

}
