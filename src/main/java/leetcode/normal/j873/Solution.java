package leetcode.normal.j873;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/">873. 最长的斐波那契子序列的长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];
                ans = Math.max(ans, checkMaxFibLen(arr, first, second));
            }
        }
        return ans;
    }

    int checkMaxFibLen(int[] arr, int first, int second) {
        int cnt = 2;
        int next = first + second;
        while (checkIfExist(arr, next)) {
            ++cnt;
            first = second;
            second = next;
            next = first + second;
        }
        return cnt == 2 ? 0 : cnt;
    }

    boolean checkIfExist(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;

        }
        return false;
    }
}