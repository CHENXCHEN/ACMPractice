package leetcode.normal.j2347;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-poker-hand/">2347. 最好的扑克手牌</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] ranks;
    char[] suits;

    public String bestHand(int[] ranks, char[] suits) {
        this.ranks = ranks;
        this.suits = suits;
        return isFlush() ? "Flush" : (isThree() ? "Three of a Kind" : (isTwo() ? "Pair" : "High Card"));
    }

    boolean isFlush() {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) return false;
        }
        return true;
    }

    boolean isThree() {
        int[] has = new int[14];
        for (int i = 0; i < ranks.length; i++) {
            if (++has[ranks[i]] == 3) {
                return true;
            }
        }
        return false;
    }

    boolean isTwo() {
        int[] has = new int[14];
        for (int i = 0; i < ranks.length; i++) {
            if (++has[ranks[i]] == 2) {
                return true;
            }
        }
        return false;
    }
}