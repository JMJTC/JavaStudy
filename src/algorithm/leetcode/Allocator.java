package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-25
 * @Description: 2502. 设计内存分配器
 * @Version: 1.0
 */

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
public class Allocator {
    // 定义一个数组，用于存储内存分配情况
    int[] vec;
    // 定义一个变量，用于存储内存长度
    int length;

    // 构造函数，初始化内存长度
    public Allocator(int n) {
        vec=new int[n];
        length=n;
    }

    // 分配内存，返回分配的起始位置
    public int allocate(int size, int mID) {
        // 如果请求的内存大小大于内存长度，则返回-1
        if(size>length){
            return -1;
        }
        int ans=-1;
        // 遍历数组，寻找连续的0，表示可用的内存
        for(int i=0;i<vec.length;i++){
            int count=0;
            int j=i;
            // 统计连续的0的个数
            while(j<vec.length&&vec[j]==0){
                count++;
                if(count>=size){
                    break;
                }
                j++;
            }
            // 如果连续的0的个数大于等于请求的内存大小，则分配内存
            if(count>=size){
                length-=size;
                ans=i;
                // 将分配的内存位置设置为mID
                while(j>=i){
                    vec[j]=mID;
                    j--;
                }
                break;
            }
        }
        return ans;
    }

    // 释放内存，返回释放的内存大小
    public int freeMemory(int mID) {
        int ans=0;
        // 遍历数组，将mID对应的内存位置设置为0
        for(int i=0;i<vec.length;i++){
            if(vec[i]==mID){
                vec[i]=0;
                ans++;
            }
        }
        // 释放的内存大小等于释放的内存位置个数
        length+=ans;
        return ans;
    }
}

