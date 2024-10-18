package algorithm.tools;

/**
 * @author jmjtc
 */
public class Main {
    public static void main(String[] args) {

        double e=2.7182;
        double PI=3.1415926;
        System.out.println(PI);
        for(double x=0;x<2;x+=0.1 ){
            double temp=(Math.pow(e,1/2*x)-1);
            System.out.println(temp);
            double num=Math.sin(PI/(Math.pow(e,1/2*x)-1)-2*x*PI);
            System.out.println(num);
        }
    }
}
