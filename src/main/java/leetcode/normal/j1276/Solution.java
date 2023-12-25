package leetcode.normal.j1276;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/description/">1276. 不浪费原料的汉堡制作方案</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // 假设巨无霸汉堡为 x，小皇堡为 y
        // 那么 4x + 2y = tomatoSlices, x + y = cheeseSlices
        int pre = tomatoSlices - 2 * cheeseSlices;
        ArrayList<Integer> ans = new ArrayList<>();
        if (pre % 2 != 0 || pre < 0) return ans;
        int x = pre / 2, y = cheeseSlices - x;
        if (y < 0) return ans;
        ans.add(x);
        ans.add(y);
        return ans;
    }
}