package leetcode.normal.j1394;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-lucky-integer-in-an-array/description/">1394. 找出数组中的幸运数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
        int ans = -1;
        for (int i = 1; i < 501; i++) {
            if (i == cnt[i]) ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }
}