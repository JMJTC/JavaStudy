package algorithm.pat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class L1_005 {
    public static void main(String[] args) {
        Map<Integer,stu> map=new HashMap<>();
        //读入信息
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        stu[] students=new stu[n];
        for(int i=0;i<n;i++){
            String id=sc.next();
            int tempNumber=sc.nextInt();
            int realNumber=sc.nextInt();
            students[i]=new stu(id,tempNumber,realNumber);
            map.put(tempNumber,students[i]);
        }
        n= sc.nextInt();
        //可用hashtable优化
        for(int i=0;i<n;i++){
            int num= sc.nextInt();
            stu student=map.get(num);
            System.out.println(student.id+" "+student.realNumber);
//            for (stu student : students) {
//                if (student.tempNumber == num) {
//                    System.out.println(student.id + " " + student.realNumber);
//                    break;
//                }
//            }
        }

    }
}

class stu{
    String id;
    int tempNumber;
    int realNumber;

    public stu(String id, int tempNumber, int realNumber) {
        this.id = id;
        this.tempNumber = tempNumber;
        this.realNumber = realNumber;
    }
}
