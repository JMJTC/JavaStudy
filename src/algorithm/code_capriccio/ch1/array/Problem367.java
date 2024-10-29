package algorithm.code_capriccio.ch1.array;

import static algorithm.everyweekstudy.week4.week4_4.mySqrt;

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
