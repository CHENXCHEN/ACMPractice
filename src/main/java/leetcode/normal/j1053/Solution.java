package leetcode.normal.j1053;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/previous-permutation-with-one-swap/">1053. 交换一次的先前排列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) i--;
        int j = i;
        if (j >= 0) {
            int k = j;
            for (int x = k + 1; x < arr.length; x++) {
                if (arr[x] < arr[j] && (arr[k] == arr[j] || arr[x] > arr[k])) {
                    k = x;
                }
            }
            int tmp = arr[j];
            arr[j] = arr[k];
            arr[k] = tmp;
        }
        return arr;
    }
}