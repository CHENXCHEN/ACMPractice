package leetcode.normal.j45;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/">45. 跳跃游戏 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int jump(int[] nums) {
        // end 表示是当前步数可以到达的最远的边界
        // maxPosition 表示是到当前位置可以到达最远的地方
        // 如果走到边界之后，我们可以拓宽边界为 maxPositions，每次拓宽边界步数都必须 +1
        int n = nums.length, end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}