package leetcode.normal.j1619;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/">1619. 删除某些元素后的数组均值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int k = (int) (n * 0.05);
        int ans = 0;
        for (int i = k; i < n - k; i++) ans += arr[i];
        return 1.0 * ans / (n - 2 * k);
    }
}