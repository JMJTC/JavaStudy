package Algorithm.CodeCapriccio.Ch1_Array;

import static Algorithm.EveryWeekStudy.week4.week4_4.mySqrt;

/**
 * @author jmjtc
 */
public class Problem367 {
    public static void main(String[] args) {

    }
}
class Problem367_Solution{
    public boolean isPerfectSquare(int num) {
        int sqrt=mySqrt(num);
        return sqrt * sqrt == num;
    }
}
