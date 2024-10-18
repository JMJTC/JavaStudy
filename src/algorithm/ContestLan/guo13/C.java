package algorithm.ContestLan.guo13;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        new C().input(sc);
    }
    public static void input1(Scanner sc){
        int n= sc.nextInt();
        int count= sc.nextInt();
        Node[] arr=new Node[n+2];
        arr[0]=new Node();
        arr[n+1]=new Node();
        for (int i=1;i<=n;i++){
            arr[i]=new Node();
            arr[i].val=i;
            arr[i].next=arr[i-1];
        }
        for(int i=0;i<count;i++){
            char c= sc.next().charAt(0);
            int index= sc.nextInt();
            if(c=='L'){
                Node temp=arr[index];
                arr[index+1].next=arr[index-1];

            }
        }

    }
    public static void input(Scanner sc){
        int n= sc.nextInt();
        int count= sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=i;
        }
        for(int i=0;i<count;i++){
            char c= sc.next().charAt(0);
            int index= sc.nextInt();
            if(c=='L'){
                int temp=arr[index];
                for(int j=1;j<=n;j++){
                    if(arr[j]<temp){
                        arr[j]+=1;
                    }
                }
                arr[index]=1;
            }else{
                int temp=arr[index];
                for(int j=1;j<=n;j++){
                    if(arr[j]>temp){
                        arr[j]-=1;
                    }
                }
                arr[index]=n;
            }
        }
        int[] ans=new int[n+1];
        for(int i=1;i<=n;i++){
            ans[arr[i]]=i;
        }
        for(int i=1;i<=n;i++){
            System.out.print(ans[i]+" ");
        }
    }
    //[1,2,3,4,5]
    //[3,1,2,4,5]
}

class Node{
    int val;
    Node next;
}
