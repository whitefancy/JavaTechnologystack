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

        //string 2 array
        String s= "[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]";
        String s1=s.replace('[','{').replace(']','}');
        System.out.println(s1);

        //list to array
        List<Integer> order = new ArrayList<>();
        order.stream().mapToInt((Integer in)-> in).toArray();
    }
    public void String2array(){
        //string 2 array
        String s= "[[6765,184288,53874],[13769,607194,451649],[43325,568099,982005],[47356,933141,123943],[59810,561434,119381],[75382,594625,738524],[111895,617442,587304],[143767,869128,471633],[195676,285251,107127],[218793,772827,229219],[316837,802148,899966],[329669,790525,416754],[364886,882642,535852],[368825,651379,6209],[382318,992082,300642],[397203,478094,436894],[436174,442141,612149],[502967,704582,918199],[503084,561197,625737],[533311,958802,705998],[565945,674881,149834],[615397,704261,746064],[624917,909316,831007],[788731,924868,633726],[791965,912123,438310]]";
        String s1=s.replace('[','{').replace(']','}');
        System.out.println(s1);
    }
    public void test(){
        String2array();
    }
}
