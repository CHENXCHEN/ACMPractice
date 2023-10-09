package leetcode.normal.j2578;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-with-minimum-sum/description/">2578. 最小和分割</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int splitNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        list.sort((x, y) -> x - y);
        int[] vv = new int[2];
        int cur = 0;
        for (int i = 0; i < list.size(); i++) {
            vv[cur] = vv[cur] * 10 + list.get(i);
            cur ^= 1;
        }
        return vv[0] + vv[1];
    }
}