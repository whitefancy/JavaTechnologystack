package usages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeChange {
    public void Int2Char(){
        int number = 9;
        // int to char
        char cNumber= (char) (number+'0');

        //array to string
        int[][] edges =new int[][]{{0,2},{1,2},{2,0}};
        Arrays.toString(edges);

        //list to array
        List<Integer> order = new ArrayList<>();
        order.stream().mapToInt((Integer in)-> in).toArray();
    }
}
