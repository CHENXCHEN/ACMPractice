package leetcode.normal.j3222;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-winning-player-in-coin-game/description/">3222. 求出硬币游戏的赢家</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String losingPlayer(int x, int y) {
        int cnt = Math.min(x, y / 4);
        return (cnt & 1) == 1 ? "Alice" : "Bob";
    }
}