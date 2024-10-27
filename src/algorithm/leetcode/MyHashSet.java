package algorithm.leetcode;

public class MyHashSet {
    private final int LENGTH=10000;
    private final int increment=100;

    private int[] set;
    private boolean[] flag;
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）
    }

    public MyHashSet() {
        set=new int[LENGTH];
        flag=new boolean[LENGTH];
    }

    public void add(int key) {
        int length=set.length;
        int index=(key%length);
        while(flag[index]&&set[index]!=key){
            index=(index+1)%length;
        }
        if(set[index]!=key){
            set[index]=key;
            flag[index]=true;
        }
    }

    public void remove(int key) {
        int length=set.length;
        int index=(key%length);
        while(set[index]!=key){
            index=(index+1)%length;
        }
        flag[index]=false;
    }

    public boolean contains(int key) {
        int length=set.length;
        int index=(key%length);
        int count=0;
        while(set[index]!=key){
            if(count>=length){
                return false;
            }
            index=(index+1)%length;
            count++;
        }
        return flag[index];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
    }
}*/
