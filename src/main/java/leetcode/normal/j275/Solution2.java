package leetcode.normal.j275;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode-cn.com/problems/h-index-ii/">275. H 指数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int hIndex(int[] citations) {
        int ans = 0, n = citations.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int res = n - mid;
            if (citations[mid] >= res) {
                ans = res;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}