package designpattern.juedirank;

import java.util.Map;
import java.util.TreeMap;

public class RankImpl implements Rank {
    TreeMap<Long, Integer> rank = new TreeMap<>();

    @Override
    public Long getRankById(Long id) {
        return null;
    }

    @Override
    public Long getIdByRank(Long rank) {
        return null;
    }

    @Override
    public Integer updatePower(Long id, Integer power) {
        return null;
    }
}
