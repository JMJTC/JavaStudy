package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem1276 {
    public static void main(String[] args) {

    }
}

class Problem1276_Solution{
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices){
        if(tomatoSlices%2!=0||tomatoSlices<cheeseSlices*2||tomatoSlices>cheeseSlices*4){
            return new ArrayList<>();
        }
        int bigSum=0,smallSum=0;
        //假设全部是大
        bigSum=cheeseSlices;
        int tomato=bigSum*4;
        smallSum=(tomato-tomatoSlices)/2;
        bigSum=cheeseSlices-smallSum;
        return new ArrayList<>(Arrays.asList(bigSum,smallSum));
    }
}
