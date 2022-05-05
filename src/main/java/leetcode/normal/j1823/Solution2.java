package leetcode.normal.j1823;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 1823. 找出游戏的获胜者
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }
}
