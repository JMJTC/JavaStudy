package algorithm.everyweekstudy.week1;

import java.util.Scanner;
import java.util.Arrays;

public class _10_22_3 {
    public static void main(String[] args){
        String line;
        Scanner in=new Scanner(System.in);//不可变
        StringBuilder name=new StringBuilder();//可变
        //判断是否有下一行 ctrl+d 跳出
        while(in.hasNext()){
            line=in.next();
            //去掉“,使用替换操作
            line=line.replace("\"","");
            //添加到name尾部
            name.append(line);
            name.append(",");
        }
        //先将name转换成string类型，以逗号分割
        String[] names=name.toString().split(",");
        Arrays.sort(names);//默认升序
        long ans=0;
        for(int i=0;i<names.length;i++){
            long sum=0;
            for(int j=0;j<names[i].length();j++){
                sum+=names[i].charAt(j)-'A'+1;
                //获取指定索引位置处的字符(char)
            }
            ans+=sum*(i+1);
        }
        System.out.println(ans);
    }



}
