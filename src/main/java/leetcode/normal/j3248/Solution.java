package leetcode.normal.j3248;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/snake-in-matrix/description/">3248. 矩阵中的蛇</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<Character, int[]> dir = new HashMap<>();
        dir.put('U', new int[]{-1, 0});
        dir.put('D', new int[]{1, 0});
        dir.put('L', new int[]{0, -1});
        dir.put('R', new int[]{0, 1});
        int x = 0, y = 0;
        for (String command : commands) {
            int[] d = dir.get(command.charAt(0));
            x += d[0];
            y += d[1];
        }
        return x * n + y;
    }
}