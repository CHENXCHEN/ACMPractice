package leetcode.normal.j1534;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-good-triplets/description/">1534. 统计好三元组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diffA = Math.abs(arr[i] - arr[j]);
                for (int k = j + 1; k < arr.length; k++) {
                    int diffB = Math.abs(arr[k] - arr[j]);
                    int diffC = Math.abs(arr[i] - arr[k]);
                    if (diffA <= a && diffB <= b && diffC <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}