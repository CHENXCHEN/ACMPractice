package leetcode.normal.j1823;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 1823. 找出游戏的获胜者
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int findTheWinner(int n, int k) {
        k -= 1;
        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) circle.add(i);
        int cur = 0;
        for (int i = 0; i < n - 1; i++) {
            cur = (cur + k) % circle.size();
            System.out.println("remove: " + circle.get(cur));
            circle.remove(cur);
        }
        return circle.get(0) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findTheWinner(10, 3);
    }
}
