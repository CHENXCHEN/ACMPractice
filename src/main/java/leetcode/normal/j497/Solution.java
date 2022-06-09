package leetcode.normal.j497;

import java.util.Random;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 * 497. 非重叠矩形中的随机点
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] preSum;
    int[][] reacts;
    int sum;
    Random rand;


    public Solution(int[][] rects) {
        this.reacts = rects;
        preSum = new int[rects.length];
        sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int lenX = rects[i][2] - rects[i][0] + 1;
            int lenY = rects[i][3] - rects[i][1] + 1;
            sum += lenX * lenY;
            preSum[i] = sum;
        }
        rand = new Random();
    }

    public int[] pick() {
        int pos = rand.nextInt(sum);
        int idx = binarySearchIdx(pos + 1);
        int nPos = pos;
        if (idx > 0) nPos -= preSum[idx - 1];
        int[] rect = reacts[idx];
        int a = rect[0], b = rect[1], y = rect[3];
        int col = y - b + 1;
        int da = nPos / col;
        int db = nPos - col * da;
        return new int[]{a + da, b + db};
    }

    int binarySearchIdx(int pos) {
        int left = 0, right = preSum.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (pos == preSum[mid]) return mid;
            if (preSum[mid] < pos) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */