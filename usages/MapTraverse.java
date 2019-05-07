package usages;

import java.util.HashMap;
import java.util.Map;

public class MapTraverse {
    Map<Integer,Integer> map;
    public void traverseEntry(){
        map = new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            entry.getKey();
            entry.getValue();
        }
    }
}
