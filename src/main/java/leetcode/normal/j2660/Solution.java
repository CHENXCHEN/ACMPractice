package leetcode.normal.j2660;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/description/">2660. 保龄球游戏的获胜者</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0, score2 = 0, n = player1.length;
        for (int i = 0; i < n; i++) {
            score1 += getScore(player1, i);
            score2 += getScore(player2, i);
        }
        if (score1 > score2) return 1;
        else if (score1 < score2) return 2;
        return 0;
    }

    int getScore(int[] player, int pos) {
        int pre = 0;
        for (int i = 1; i <= 2 && pos - i >= 0; i++) {
            pre = Math.max(pre, player[pos - i]);
        }
        return pre == 10 ? player[pos] * 2 : player[pos];
    }
}