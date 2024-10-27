package designpattern.builderpattern.builderproblem;

import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 客户端
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BikeDirector director;
        BikeBuilder builder;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (str.equals("mountain")) {
                builder = new MountainBikeBuilder();
                director = new BikeDirector(builder);
            }else{
                builder=new HighwayBikeBuilder();
                director=new BikeDirector(builder);
            }
            Bike bike = director.construct();
            System.out.println(bike);
        }
    }
}
