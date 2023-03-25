package leetcode.normal.j1574;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/">1574. 删除最短的子数组使剩余数组有序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, j = n - 1;
        // 找到最长的后缀数组
        while (j > 0 && arr[j - 1] <= arr[j]) --j;
        if (j == 0) return 0;
        int ans = j;
        // 枚举符合当前前缀的后缀，计算需要删除的元素个数
        for (int i = 0; i < n; i++) {
            while (j < n && arr[i] > arr[j]) ++j;
            ans = Math.min(ans, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                break;
            }
        }
        return ans;
    }
}