package designpattern.juedirank;

//排行榜适合用Redis的zset数据结构实现
public interface Rank {
    /**
     * 根据Player的唯⼀id查询玩家的排名
     * 实现方式 调用Redis 的 ZRANK 方法
     *
     * @param id 玩家id
     * @return 当前排名
     */
    Long getRankById(Long id);

    /**
     * 查询排名第x位的玩家标识id
     * 实现方式 调用Redis 的 ZRANGE  方法
     *
     * @param rank 当前排名
     * @return 玩家id
     */
    Long getIdByRank(Long rank);

    /**
     * 战力变化时更新排行榜
     * 实现方式 调用Redis 的 zincrby  方法
     *
     * @param id    玩家id
     * @param power 战力
     * @return 当前战力
     */
    Integer updatePower(Long id, Integer power);
}
