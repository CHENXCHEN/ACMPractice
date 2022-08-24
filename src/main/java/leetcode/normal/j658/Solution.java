package leetcode.normal.j658;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-k-closest-elements/">658. 找到 K 个最接近的元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ceilPos = ceilPos(arr, x);
        int left = ceilPos, right = ceilPos;
        if (ceilPos != arr.length - 1) {
            if (Math.abs(arr[ceilPos] - x) > Math.abs(arr[ceilPos + 1] - x)) {
                left = right = ceilPos + 1;
            }
        }
        while (right - left + 1 != k) {
            if (left == 0) right++;
            else if (right == arr.length - 1) left--;
            else if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) left--;
            else right++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) ans.add(arr[i]);
        return ans;
    }

    int ceilPos(int[] arr, int x) {
        int left = 0, right = arr.length - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < x) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}