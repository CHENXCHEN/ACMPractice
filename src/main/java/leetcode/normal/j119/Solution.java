package leetcode.normal.j119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/description/">119. 杨辉三角 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res[j] += res[j - 1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) list.add(res[i]);
        return list;
    }
}