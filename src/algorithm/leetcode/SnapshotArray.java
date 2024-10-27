package algorithm.leetcode;

/**
 * @author jmjtc
 */
public class SnapshotArray {
    private int[] arr;
    private int[] snap=new int[5001];
    private int count=0;
    public SnapshotArray(int length) {
        arr=new int[length];
    }

    public void set(int index, int val) {
        arr[index]=val;
    }

    public int snap() {
        snap[count]=arr[count];
        count++;
        return count-1;
    }


}
