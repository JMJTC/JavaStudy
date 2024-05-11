package Algorithm.LeetCode;

/**
 * @author jmjtc
 */
public class Problem2391 {
    public static void main(String[] args) {
        String[] garbage={"G","P","GP","GG"};
        int[] travel={2,4,3};
        System.out.println(new Problem2391().garbageCollection(garbage,travel));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int ans=0;
        int [][] data=new int[garbage.length][3];
        char[] garbageChar=new char[]{'M','P','G'};
        int[] endIndex=new int[3];
        for(int i=0;i<garbage.length;i++){
            for(char c:garbage[i].toCharArray()){
                if(c=='M'){
                    data[i][0]++;
                    continue;
                }
                if(c=='P'){
                    data[i][1]++;
                    continue;
                }
                if(c=='G'){
                    data[i][2]++;
                    continue;
                }
            }
        }
        //设置标志
        for(int i=0;i<3;i++){
            int index=garbage.length;
            for(int j=garbage.length-1;j>=0;j--){
                if(data[j][i]>0){
                    break;
                }else{
                    index--;
                }
            }
            endIndex[i]=index;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<garbage.length;j++){
                ans+=data[j][i];
                if(j!=garbage.length-1&&(j+1)<endIndex[i]){
                    ans+=travel[j];
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}

