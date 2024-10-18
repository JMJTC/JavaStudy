package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.*;

/**
 * @author jmjtc
 */

//方一:超时了，可能是排字典序的时间复杂度太高
public class Problem322 {
    private List<String> ans=new ArrayList<>();
    private List<String> path=new ArrayList<>();
    private boolean[] used;
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> data=Arrays.asList("JFK","SFO");
        tickets.add(data);
        data=Arrays.asList("JFK","ATL");
        tickets.add(data);
        data=Arrays.asList("SFO","ATL");
        tickets.add(data);
        data=Arrays.asList("ATL","JFK");
        tickets.add(data);
        data=Arrays.asList("ATL","SFO");
        tickets.add(data);

        System.out.print(tickets.toString());
        new Problem322().findItinerary(tickets);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        used=new boolean[tickets.size()];
        path.add("JFK");
        backTracking(tickets,0,0,"JFK");
        System.out.print(ans.toString());
        return ans;
    }

    public boolean  backTracking(List<List<String>> tickets,int index,int count,String start){
        if(count==tickets.size()){
////            if("SFO".equals(path.get(2))){
////                System.out.print(1);
////            }
//            if(ans.isEmpty()){
//                ans=new ArrayList<>(path);
//            }else{//比较字典序
//                for(int i=0;i<ans.size();i++){
//                    for(int j=0;j<3;j++){
//                        if(ans.get(i).charAt(j)>path.get(i).charAt(j)){
//                            ans=new ArrayList<>(path);
//                            return;
//                        }else if(ans.get(i).charAt(j)<path.get(i).charAt(j)){
//                            return;
//                        }
//                    }
//                }
//            }
//            return;
            ans=new ArrayList<>(path);
            return true;
        }

        for(int i=index;i<tickets.size();i++){
            String from=tickets.get(i).get(0);
            String to=tickets.get(i).get(1);
            if(from.equals(start)&& !used[i]){
                path.add(to);
                used[i]=true;
            }else{
                continue;
            }
            if(backTracking(tickets,0,count+1,to)){
                return true;
            }
            //回溯
            used[i]=false;
            path.remove(path.size()-1);
        }
        return false;
    }
}

//方二，利用优先队列,hashmap
class Problem322Solution2{
    private Map<String, PriorityQueue<String>> record=new HashMap<>();
    private List<String> ans=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets){
        //初始化record
        for(int i=0;i<tickets.size();i++){
            String from=tickets.get(i).get(0),to=tickets.get(i).get(1);
            if(!record.containsKey(from)){
                record.put(from,new PriorityQueue<>());
            }
            record.get(from).offer(to);
        }

        backTracking("JFK");
        Collections.reverse(ans);
        return ans;
    }

    public void backTracking(String start){
        while(record.containsKey(start)&& !record.get(start).isEmpty()){
            String tmp=record.get(start).poll();
            backTracking(tmp);
        }
        ans.add(start);
    }
}

//方三，回溯模板，有序map TreeMap
class Problem322Solution3{
    //定义一个Map，用于存储每个起点机场能到达的终点机场及对应的航班次数
    private Map<String,Map<String,Integer>> map=new HashMap<>();
    //定义一个List，用于存储最终的行程
    private List<String> ans=new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets){
        //初始化map
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            //获取当前航班的起点机场和终点机场
            String from = ticket.get(0), to = ticket.get(1);
            //如果map中已经包含了当前起点机场，则获取对应的map
            if (map.containsKey(from)) {
                temp = map.get(from);
                //将当前航班添加到map中
                temp.put(to, temp.getOrDefault(to, 0) + 1);
            } else {
                //如果map中不包含当前起点机场，则创建一个新的map，并将当前航班添加到新map中
                temp = new TreeMap<>();
                temp.put(to, 1);
            }
            //将当前起点机场及其对应的map添加到map中
            map.put(from, temp);
        }
        //将起始机场添加到行程中
        ans.add("JFK");
        //调用回溯函数
        backTracking(tickets.size());
        //返回行程
        return ans;
    }

    public boolean backTracking(int size){
        //如果行程中的机场数量达到预期数量，则返回true
        if(ans.size()==size+1){
            return true;
        }

        //获取当前机场
        String temp=ans.get(ans.size()-1);
        //如果map中包含当前机场，则遍历当前机场能到达的机场及其对应的航班次数
        if(map.containsKey(temp)){
            for(Map.Entry<String,Integer> entry:map.get(temp).entrySet() ){
                //获取当前机场能到达的机场对应的航班次数
                int count=entry.getValue();
                //如果当前机场能到达的机场对应的航班次数大于0，则说明可以飞该航班
                if(count>0){
                    //将当前机场能到达的机场添加到行程中
                    ans.add(entry.getKey());
                    //将当前机场能到达的机场对应的航班次数减1
                    entry.setValue(count-1);
                    //调用回溯函数
                    if(backTracking(size)){
                        //如果行程中的机场数量达到预期数量，则返回true
                        return true;
                    }
                    //将当前机场能到达的机场从行程中移除
                    ans.remove(ans.size()-1);
                    //将当前机场能到达的机场对应的航班次数设置为原始值
                    entry.setValue(count);
                }
            }
        }
        //如果当前机场不能到达任何机场，则返回false
        return false;
    }
}