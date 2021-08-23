package leetcode.normal.j789;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/escape-the-ghosts/
 * 789. 逃脱阻碍者
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int you = Math.abs(target[0]) + Math.abs(target[1]);
        return !Arrays.stream(ghosts)
                .mapToInt(ghost -> Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]))
                .filter(x -> x <= you).findFirst().isPresent();
    }
}