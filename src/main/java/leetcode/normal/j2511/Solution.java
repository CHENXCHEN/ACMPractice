package leetcode.normal.j2511;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/">2511. 最多可以摧毁的敌人城堡数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int captureForts(int[] forts) {
        int ans = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                int left = i - 1;
                while (left > 0 && forts[left] == 0) left--;
                if (left >= 0 && forts[left] == -1) {
                    ans = Math.max(ans, i - left - 1);
                }
                int right = i + 1;
                while (right < forts.length - 1 && forts[right] == 0) right++;
                if (right < forts.length && forts[right] == -1) {
                    ans = Math.max(ans, right - i - 1);
                    i = right;
                }
            }
        }
        return ans;
    }
}