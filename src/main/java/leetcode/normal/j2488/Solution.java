package leetcode.normal.j2488;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-subarrays-with-median-k/">2488. 统计中位数为 K 的子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countSubarrays(int[] nums, int k) {
        // s[i] 为 [0,i] > k 的个数 - [0,i] < k 的个数
        // 那么，如果 [i,j] 可以形成合法的子数组，那么 [i,j] 内必须包含 k 元素，
        // 若 s[j] - s[i] == 0 并且 j - i 为奇数，那么可以形成
        // 若 s[j] - s[i] == 1 并且 j - i 为偶数，那么可以形成
        // 我们可以从元素 k 的所在位置右边开始枚举 j，找左边的 i
        Map<Integer, int[]> mm = new HashMap<>();
        int ss = 0, i = 0;
        mm.put(0, new int[]{0, 1});
        while (i < nums.length && nums[i] != k) {
            if (nums[i] > k) ++ss;
            else --ss;
            mm.putIfAbsent(ss, new int[]{0, 0});
            mm.get(ss)[i & 1]++;
            ++i;
        }
        int ans = 0;
        while (i < nums.length) {
            if (nums[i] > k) ++ss;
            else if (nums[i] < k) --ss;
            ans += calc(mm.get(ss), i, 1);
            ans += calc(mm.get(ss - 1), i, 0);
            i++;
        }
        return ans;
    }

    int calc(int[] ss, int cur, int mod) {
        // 如果要找 (cur - x) % 2 = mod 的数量，(0 <= mod <=1)
        // 假设 mod 为奇数，那么 x = (cur - mod) % 2 也得为奇数
        // 假设 mod 为偶数，那么 x = (cur - mod) % 2 也得为偶数
        if (ss == null) return 0;
        return ss[(cur - mod) & 1];
    }
}
/**
 * [5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14]
 * 6
 * <p>
 * (6,7]
 * (3,7]
 * (3,8]
 * (2,8]
 * (6,9]
 * (3,9]
 * (5,10]
 * (6,10]
 * (5,11]
 * (5,15]
 */