package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-26
 * @Description: 1472. 设计浏览器历史记录
 * @Version: 1.0
 */
public class Problem1472 {
    public static void main(String[] args) {

    }
}

class BrowserHistory {
    private String[] page; // 用于存储浏览历史记录的数组
    private int index=0; // 记录最后一个网址的下标
    private int cur=0; // 记录当前网站的下标

    public BrowserHistory(String homepage) {
        page=new String[1000]; // 初始化存储历史记录的数组，大小为1000
        page[index]=homepage; // 将初始主页存储在数组的第一个位置
        cur=0; // 当前下标设置为0
    }

    public void visit(String url) {//访问
        page[++cur]=url; // 将新的网址存储在当前下标的下一个位置，并将当前下标加1
        index=cur; // 更新最后一个网址的下标为当前下标
    }

    public String back(int steps) {
        int ans=cur-steps; // 计算后退后的下标
        if(ans<=0){ // 如果后退后的下标小于等于0
            cur=0; // 将当前下标设置为0
            return page[cur]; // 返回主页
        }else{
            cur=ans; // 否则将当前下标设置为后退后的下标
            return page[cur]; // 返回后退后的网址
        }
    }

    public String forward(int steps) {
        int ans=cur+steps; // 计算前进后的下标
        if(ans>=index){ // 如果前进后的下标大于等于最后一个网址的下标
            cur=index; // 将当前下标设置为最后一个网址的下标
            return page[cur]; // 返回最后一个网址
        }else{
            cur=ans; // 否则将当前下标设置为前进后的下标
            return page[cur]; // 返回前进后的网址
        }
    }
}
