package leetcode.normal.j1238;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/circular-permutation-in-binary-representation/">1238. 循环码排列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        // 格雷码的公式法
        // 为了通用，我们假定是从 0 开始计算格雷码，那么第 i 个格雷码与第 i + 1 个格雷码有两种情况
        // 如果要从 start 开始，那么对所有结果异或 start 即可
        int tot = 1 << n;
        for (int i = 0; i < tot; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }
}