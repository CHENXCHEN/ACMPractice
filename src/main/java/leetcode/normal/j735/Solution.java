package leetcode.normal.j735;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/asteroid-collision/">735. 行星碰撞</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            int nowAbs = Math.abs(asteroid);
            int nowSigh = getSign(asteroid);
            boolean isShouldAdd = true;
            while (!stack.isEmpty()) {
                int peek = stack.getLast();
                int peekAbs = Math.abs(peek);
                int peekSign = getSign(peek);
                if (peekSign > 0 && nowSigh < 0) {
                    if (peekAbs == nowAbs) {
                        stack.removeLast();
                        isShouldAdd = false;
                        break;
                    } else if (peekAbs > nowAbs) {
                        isShouldAdd = false;
                        break;
                    } else {
                        stack.removeLast();
                    }
                } else {
                    break;
                }
            }
            if (isShouldAdd) stack.add(asteroid);
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.removeFirst();
        }
        return ans;
    }

    int getSign(int vv) {
        return vv < 0 ? -1 : 1;
    }

    public static void main(String[] args) {
        int[] res = {-2, -1, 1, 2};
        Solution solution = new Solution();
        solution.asteroidCollision(res);
    }
}