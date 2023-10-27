package week2;

public class week2_8 {

}

class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int length=height.length;
        int maxX=0;
        for(int i=0;i<length;i++){
            if(height[i]<height[maxX]){//如果后面高度小于maxX所在的高度则跳出，则跳出
                continue;
            }
            for(int j=i+1;j<length;j++){
                int temp=(j-i)*(Math.min(height[i], height[j]));
                if(temp>area){
                    area=temp;
                    maxX=i;
                }
            }
        }
        return area;
    }
}

//class Solution {
//    public int maxArea(int[] height) {
//        int i = 0, j = height.length - 1, res = 0;
//        while(i < j) {
//            res = height[i] < height[j] ?
//                    Math.max(res, (j - i) * height[i++]):
//                    Math.max(res, (j - i) * height[j--]);
//        }
//        return res;
//    }
//}

