package algorithm.everyweekstudy.week5;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class week5_3 {
    public static void main(String[] args) {
        String s="tree";
        System.out.println(new week5_3_Solution().frequencySort(s));
    }
}

//class dataAndIndex{
//    int count;
//    int index;
//    public dataAndIndex(int i,int j){
//        this.count=i;
//        this.index=j;
//    }
//    public dataAndIndex(){}
//}
class week5_3_Solution {
    public String frequencySort(String s) {
        //根据Ascll码表
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();
        //初始化cnts,记录每个字符出现的次数
        //第一层记录字符，第二层记录次数
        for (int i = 0; i < 128; i++) {
            cnts[i][0] = i;
        }
        for (char c : cs) {
            cnts[c][1]++;
        }
        //自定义排序，
        Arrays.sort(cnts, (a, b)->{
            //大于零就交换
            return b[1]-a[1];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char)cnts[i][0];
            int k = cnts[i][1];
            while (k-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
//    public  void swap(dataAndIndex[] nums, int i, int j) {
//        dataAndIndex tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
//
//    /* 哨兵划分 */
//    public  int partition(dataAndIndex[] nums, int left, int right) {
//        // 以 nums[left] 作为基准数
//        int i = left, j = right;
//        while (i < j) {
//            while (i < j && nums[j].count >= nums[left].count) {
//                j--;          // 从右向左找首个小于基准数的元素
//            }
//            while (i < j && nums[i].count <= nums[left].count) {
//                i++;          // 从左向右找首个大于基准数的元素
//            }
//            swap(nums, i, j); // 交换这两个元素
//        }
//        swap(nums, i, left);  // 将基准数交换至两子数组的分界线
//        return i;             // 返回基准数的索引
//    }
//
//    public String frequencySort(String s) {
//        String ans= "";
//        //记录每个字符出现的次数
//        //int data=new int[62];
//        dataAndIndex[] record=new dataAndIndex[62];
//        //初始化
//        for(int i=0;i<62;i++){
//            record[i]=new dataAndIndex(0,i);
//        }
//        //0~9,A~Z,a~z
//        int length=s.length();
//        for(int i=0;i<length;i++){
//            int index=s.charAt(i)-'0';
//            if(index<=9){
//                record[index].count++;
//            }else if(index<=42){
//                record[index-7].count++;
//            }else{
//                record[index-13].count++;
//            }
//        }
//        //根据count的大小进行排序，快速排序
//        partition(record,0,61);
//        //生成ans;
//        for(int i=0;i<62;i++){
//            if(record[i].count==0){
//                continue;
//            }
//            if(record[i].index<=9){
//                String temp=(String)"record[i].index";
//                ans=ans.concat(temp);
//            }else if(record[i].index<=35){
//                String temp=Integer.toString(record[i].index+55);
//                ans=ans.concat(temp);
//            }else{
//                String temp=Integer.toString(record[i].index+61);
//            }
//        }
//        return ans;
//    }
}
