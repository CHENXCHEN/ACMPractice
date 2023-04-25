package leetcode.normal.j2418;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-the-people/">2418. 按身高排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] index = new Integer[names.length];
        for (int i = 0; i < names.length; i++) index[i] = i;
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) ans[i] = names[index[i]];
        return ans;
    }
}