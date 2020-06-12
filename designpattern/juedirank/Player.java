package designpattern.juedirank;

import java.util.ArrayList;

public class Player {
    private Long id;
    private Integer power;
    private Rank rank;

    void changePower(int delta) {
        power += delta;
        rank.updatePower(id, power);
    }
}
