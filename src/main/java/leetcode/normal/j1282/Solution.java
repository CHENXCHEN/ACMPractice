package leetcode.normal.j1282;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/">1282. 用户分组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            ArrayList<Integer> list = mp.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                ans.add(list);
                mp.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}