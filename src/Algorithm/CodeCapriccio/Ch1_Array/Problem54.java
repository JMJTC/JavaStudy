package Algorithm.CodeCapriccio.Ch1_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem54 {
    public List<Integer> spiralOrder(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new ArrayList();
        }
        int rows = array.length, columns = array[0].length;
        List<Integer> order=new ArrayList<>();
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(array[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(array[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(array[bottom][column]) ;
                }
                for (int row = bottom; row > top; row--) {
                    order.add(array[row][left]) ;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}


