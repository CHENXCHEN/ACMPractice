package leetcode.normal.j2234;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-total-beauty-of-the-gardens/description/">2234. 花园的最大总美丽值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        for (int i = 0; i < flowers.length; i++) flowers[i] = Math.min(flowers[i], target);
        Arrays.sort(flowers);
        reverse(flowers);
        int n = flowers.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += flowers[i];
        long ans = 0;
        if ((long) target * n - sum <= newFlowers) {
            ans = (long) full * n;
        }
        long pre = 0;
        int ptr = 0;
        // 枚举完善的花园数量即可，答案为：完善的花园 + 不完善的花园
        for (int i = 0; i < n; i++) {
            if (i != 0) pre += flowers[i - 1];
            if (flowers[i] == target) continue;
            long rest = newFlowers - ((long) target * i - pre);
            // 如果没有花了，那么后面的方案都无法成立
            if (rest < 0) break;
            // 找到第一个 flowers[ptr]，符合剩余的花至少可以使得 [ptr,n-1] 的花朵数都为 flowers[ptr]
            while (ptr < i || (long) flowers[ptr] * (n - ptr) - sum > rest) {
                sum -= flowers[ptr];
                ptr++;
            }
            rest -= (long) flowers[ptr] * (n - ptr) - sum;
            ans = Math.max(ans, (long) full * i + (long) partial * Math.min(flowers[ptr] + rest / (n - ptr), (long) target - 1));
        }
        return ans;
    }

    void reverse(int[] flowers) {
        for (int i = 0, j = flowers.length - 1; i < j; i++, j--) {
            int temp = flowers[i];
            flowers[i] = flowers[j];
            flowers[j] = temp;
        }
    }
}