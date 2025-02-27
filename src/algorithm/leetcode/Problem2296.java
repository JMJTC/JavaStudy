package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-27
 * @Description: 2296. 设计一个文本编辑器
 * @Version: 1.0
 */
public class Problem2296 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("123456");
        System.out.println(sb.substring(0,2));
    }
}

class TextEditor {
    private StringBuilder sb=new StringBuilder();
    private int cursor=0;
    private int length=0;

    public TextEditor() {

    }

    public void addText(String text) {
        length+=text.length();
        sb.insert(cursor,text);
        cursor+=text.length();
    }

    public int deleteText(int k) {
        if(cursor==0){
            return 0;
        }
        int deleteNum=Math.min(k,cursor);
        sb.delete(cursor-deleteNum,cursor);
        length-=deleteNum;
        cursor-=deleteNum;
        return deleteNum;
    }

    public String cursorLeft(int k) {
        cursor=Math.max(0,cursor-k);
        return sb.substring(Math.max(cursor - 10, 0),cursor);
    }

    public String cursorRight(int k) {
        cursor=Math.min(length,cursor+k);
        return sb.substring(Math.max(cursor - 10, 0),cursor);
    }
}
