package leetcode.normal.j2048;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/next-greater-numerically-balanced-number/description/">2048. 下一个更大的数值平衡数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int nextBeautifulNumber(int n) {
        int ans = 0;
        for (int i = n + 1; i <= 1224444; i++) {
            if (isValidNum(i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    boolean isValidNum(int num) {
        int[] cnt = new int[10];
        while (num > 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        if (cnt[0] > 0) return false;
        for (int i = 1; i < 10; i++) {
            if (cnt[i] > 0 && cnt[i] != i) return false;
        }
        return true;
    }
}