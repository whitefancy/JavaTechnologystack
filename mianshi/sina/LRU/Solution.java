package mianshi.sina.LRU;

import java.util.LinkedHashMap;

public class Solution {
    private int max;
    private LinkedHashMap<Integer, Integer> map;

    private Solution(int capacity) {
        max = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public static void main(String[] args) {
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value != -1) {
            map.remove(key);
            map.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        int old = map.getOrDefault(key, -1);
        if (old == -1 && map.size() == max) {
            int oldkey = map.entrySet().iterator().next().getKey();
            map.remove(oldkey);
        }
        map.put(key, value);
    }
}