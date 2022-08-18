package leetcode.normal.j1224;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-equal-frequency/">1224. 最大相等频率</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100001], freq = new int[100001];
        int ans = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ++cnt[num];
            freq[cnt[num]]++;
            if (cnt[num] > 1) freq[cnt[num] - 1]--;
            maxFreq = Math.max(maxFreq, cnt[num]);
            // 如果最大出现次数为1，那么删除任意一个数都可以达成
            // 如果所有数字只出现 maxFreg 和 maxFreg-1 并且最大出现次数的数只有1个，那么可以通过删除最大出现次数的那个数使得所有数都为 maxFreg - 1
            // 如果所有数字只出现 maxFreg 和 1 次 并且出现 1 次的只有一个数，那么可以通过删除这个数达到所有数都是 maxFreg 次
            boolean isOk = maxFreq == 1 ||
                    maxFreq * freq[maxFreq] + (maxFreq - 1) * freq[maxFreq - 1] == i + 1 && freq[maxFreq] == 1 ||
                    maxFreq * freq[maxFreq] + 1 == i + 1 && freq[1] == 1;
            if (isOk) ans = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        Solution solution = new Solution();
        System.out.println(solution.maxEqualFreq(nums));
    }
}