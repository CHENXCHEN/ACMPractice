package leetcode.normal.j2211;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-collisions-on-a-road/description/">2211. 统计道路上的碰撞次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countCollisions(String directions) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int ans = 0;
        int mark = 0;
        // 从左往右走，记录 R | S 的，当遇到 L 时，如果左边存在 R | S，那么一定会碰撞 +1
        for (int i = 0; i < directions.length(); i++) {
            char c = directions.charAt(i);
            if (c == 'R' || c == 'S') mark = 1;
            else if (c == 'L') ans += mark;
        }
        mark = 0;
        // 从右往左走，记录 L | S 的，当遇到 R 时，如果右边存在 L | S，那么一定会碰撞 +1
        for (int i = directions.length() - 1; i >= 0; i--) {
            char c = directions.charAt(i);
            if (c == 'L' || c == 'S') mark = 1;
            else if (c == 'R') ans += mark;
        }
        return ans;
    }
}