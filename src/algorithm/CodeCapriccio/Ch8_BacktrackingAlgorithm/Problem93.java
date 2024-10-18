package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/description/">复原ip地址</a>
 */
public class Problem93 {
    List<String> ans=new ArrayList<>();
    List<Integer> realPath=new ArrayList<>();
    int path=0;
    public static void main(String[] args) {
        new Problem93().restoreIpAddresses("101023");
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12){
            return ans;
        }
        backTracking(s,0);
        System.out.print(ans.toString());
        return ans;
    }

    public  void backTracking(String s,int index){


        if(realPath.size()==4){
            if(index!=s.length()){
                return;
            }
            StringBuilder temp=new StringBuilder();
            for(Integer i:realPath){
                temp.append(i.toString()).append('.');
            }
            temp.deleteCharAt(temp.length()-1);
            ans.add(temp.toString());
        }

        for(int i=index;i<s.length();i++){
            int tempPath=0;
            if(path==0&&s.charAt(i)-'0'==0){
                realPath.add(path);
                backTracking(s,i+1);
                //回溯
                realPath.remove(realPath.size()-1);
                if(!realPath.isEmpty()){
                    path=realPath.get(realPath.size()-1);
                }
                return;
            }else{
                path=(s.charAt(i)-'0')+path*10;
                tempPath=path;
                if(path>=0&&path<=255){
                    realPath.add(path);
                    path=0;
                }else{
                    break;
                }
                backTracking(s,i+1);
                //回溯
                realPath.remove(realPath.size()-1);
                path=tempPath;
            }
        }
    }
}















