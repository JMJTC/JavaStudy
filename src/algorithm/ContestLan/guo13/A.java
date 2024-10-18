package algorithm.ContestLan.guo13;

/**
 * @author jmjtc
 */

//重合次数
public class A {
    public static void main(String[] args) {
        int hour = 6;
        int min = 13;
        int sec = 22;
        int ans = 0;//记录重复次数
        while (true) {
            if (hour == 14 && min == 36 && sec == 20) {
                break;
            }
            if (min == sec) {
                ans++;
            }
            //当等于61秒时再重置分钟,这样就可以避免整时重复的问题了
            if (sec > 60) {
                min++;
                sec = 1;//注意:这里重置分钟时是1, 而不是0
            }
            //同上
            if (min > 60) {
                hour++;
                min = 1;
            }
            sec++;
        }
        System.out.println(ans);
    }
}
