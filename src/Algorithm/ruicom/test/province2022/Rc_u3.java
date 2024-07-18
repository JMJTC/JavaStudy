package Algorithm.ruicom.test.province2022;

import java.util.Scanner;

public class Rc_u3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int length=str.length();
        int max=0;int min=0;
        int[] data=new int[1001];
        for(int i=0;i<str.length();){
            //判断符号
            char ch='+';
            if(str.charAt(i)=='-'){
                ch='-';
            }
            if(i!=0){
                i++;
            }
            //d开头
            if(str.charAt(i)=='d'){
                i++;
                int number=0;
                while(i<length&&str.charAt(i)!='+'&&str.charAt(i)!='-'){
                    number=number*10+(str.charAt(i)-'0');
                    i++;
                }
                data[number]++;
                if(ch=='+'){
                    max+=number;
                    min+=1;
                }else{
                    max-=1;
                    min-=number;
                }
//                System.out.println(number);
            }else{//数字
                int num1=0;
                while(i<length&&str.charAt(i)!='+'&&str.charAt(i)!='-'&&str.charAt(i)!='d'){
                    num1=num1*10+(str.charAt(i)-'0');
                    i++;
                }
                //纯数字
                if(str.charAt(i)=='+'||str.charAt(i)=='-'){
                    if(ch=='+'){
                        max+=num1;
                        min+=num1;
                    }else{
                        max-=num1;
                        min-=num1;
                    }
                }else{
                    i++;
                    int number=0;
                    while(i<length&&str.charAt(i)!='+'&&str.charAt(i)!='-'){
                        number=number*10+(str.charAt(i)-'0');
                        i++;
                    }
                    data[number]+=num1;
                    if(ch=='+'){
                        max+=(number*num1);
                        min+=num1;
                    }else{
                        max-=num1;
                        min-=(number*num1);
                    }
                }
//                System.out.printf("%d %d",max,min);
            }
        }
        //print ans
        for(int i=1;i<=1000;i++){
            if(data[i]!=0){
                System.out.printf("%d %d\n",i,data[i]);
            }
        }
        System.out.printf("%d %d",min,max);
    }
}
