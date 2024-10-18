package algorithm.LeetCode;


import java.util.Arrays;

/**
 * @author jmjtc
 */
// 706. 设计哈希映射
// https://leetcode-cn.com/problems/design-hashmap/
public class MyHashMap {
    private int[] key=new int[100001];


    public MyHashMap() {
        //初始化key为-1
        Arrays.fill(key,-1);
    }

    public void put(int key, int value) {
        // 初始化
        this.key[key]=value;
    }

    public int get(int key) {
        if(this.key[key]!=-1){
            //return this.value[key];
        }
        return -1;
    }

    public void remove(int key) {

    }
}




