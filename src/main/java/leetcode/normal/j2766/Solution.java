package leetcode.normal.j2766;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/relocate-marbles/description/">https://leetcode.cn/problems/relocate-marbles/description/</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int num : nums) {
            tSet.add(num);
        }
        int n = moveFrom.length;
        for (int i = 0; i < n; i++) {
            int from = moveFrom[i], to = moveTo[i];
            if (tSet.contains(from)) {
                tSet.remove(from);
                tSet.add(to);
            }
        }
        return new ArrayList<>(tSet);
    }
}