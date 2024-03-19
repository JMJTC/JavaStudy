package Algorithm.ContestLan._14th;

/**
 * @author jmjtc
 */
public class A_FactorialSummation {
    public static void main(String[] args) {
        long sum=0;
        for(int j=1;j<=40;j++){
            long temp=1;
            for(int i=1;i<=j;i++){
                temp*=i;
                temp%=1000000000L;
            }
            sum+=temp;
            sum=sum% 1000000000L;
        }

        System.out.print(sum);
    }
}
