package leetcode.normal.j769;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted/">769. 最多能完成排序的块</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (i == max) ++ans;
        }
        return ans;
    }
}