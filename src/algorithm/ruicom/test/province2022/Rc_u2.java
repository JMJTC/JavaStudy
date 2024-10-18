package algorithm.ruicom.test.province2022;


import java.util.*;

/**
 * @author jmjtc
 */
public class Rc_u2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n种药物.m条记录
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dataTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dataTime[i] = sc.nextInt();
        }

        int[][] dataRecord = new int[m][2];
        List<List<Integer>> drug = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            dataRecord[i][0] = sc.nextInt();
            dataRecord[i][1] = sc.nextInt();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < dataRecord[i][1]; j++) {
                temp.add(sc.nextInt());
            }
            drug.add(temp);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> temp = drug.get(i);
            for (int j = 0; j < temp.size(); j++) {
                int number = temp.get(j);
                if (dataTime[temp.get(j)] != -1&&dataTime[number]!=1) {
                    int endTime = dataTime[temp.get(j)] + dataRecord[i][0];
                    for (int k = i + 1; dataRecord[k][0] < endTime; k++) {
                        //是否包含这个药
                        List<Integer> temp1=drug.get(k);
                        //遍历
                        for(int h=0;h<temp1.size();h++){
                            if(temp1.get(h)==number){
                                List<Integer> tempAns=new ArrayList<>();
                                tempAns.add(number);
                                tempAns.add(dataRecord[k][0]);
                                ans.add(tempAns);
                                drug.get(k).remove(h);
                            }
                        }
                    }
                }
            }
        }
        
    }
}
