package leetcode.normal.j2225;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-players-with-zero-or-one-losses/description/">2225. 找出输掉零场或一场比赛的玩家</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] ru = new int[100001], chu = new int[100001];
        for (int[] match : matches) {
            chu[match[0]]++;
            ru[match[1]]++;
        }
        ArrayList<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            if (ru[i] == 0 && chu[i] > 0) {
                arr1.add(i);
            }
            if (ru[i] == 1) {
                arr2.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(arr1);
        ans.add(arr2);
        return ans;
    }
}