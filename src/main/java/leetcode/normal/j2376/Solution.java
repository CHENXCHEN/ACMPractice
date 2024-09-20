package leetcode.normal.j2376;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-special-integers/description/">2376. 统计特殊整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Map<Integer, Integer> mem = new HashMap<>();

    public int countSpecialNumbers(int n) {
        String nStr = String.valueOf(n);
        int ans = 0;
        // 先计算位数小于 n 的整数个数
        int prod = 9;
        for (int i = 0; i < nStr.length() - 1; i++) {
            ans += prod;
            prod *= 9 - i;
        }
        ans += dp(0, true, nStr);
        return ans;
    }

    int dp(int mask, boolean isPrefix, String nStr) {
        if (Integer.bitCount(mask) == nStr.length()) return 1;
        // 构建当前掩码的两种状态，是前缀以及不是前缀
        int key = (mask << 1) | (isPrefix ? 1 : 0);
        if (!mem.containsKey(key)) {
            int res = 0;
            // 计算当前位数的可枚举值
            // 如果一位都没选，那么当前必须为 1
            int lower = mask == 0 ? 1 : 0;
            // 如果当前不是前缀，那么可以选到 9，如果是前缀，不能超过前缀
            int upper = isPrefix ? nStr.charAt(Integer.bitCount(mask)) - '0' : 9;
            for (int i = lower; i <= upper; i++) {
                if (((mask >> i) & 1) == 0) {
                    res += dp(mask | (1 << i), isPrefix && i == upper, nStr);
                }
            }
            mem.put(key, res);
            return res;
        }
        return mem.get(key);
    }
}