package leetcode.normal.j702;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/search-in-a-sorted-array-of-unknown-size/description/">702. 搜索长度未知的有序数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 10000;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int midValue = reader.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }
}