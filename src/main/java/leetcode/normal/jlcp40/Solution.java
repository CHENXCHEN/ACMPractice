package leetcode.normal.jlcp40;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/uOAnQW/description/">LCP 40. 心算挑战</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int res = 0, minEven = Integer.MAX_VALUE, minOdd = Integer.MAX_VALUE;
        for (int i = cards.length - cnt; i < cards.length; i++) {
            res += cards[i];
            if ((cards[i] & 1) == 0) minEven = Math.min(minEven, cards[i]);
            else minOdd = Math.min(minOdd, cards[i]);
        }
        if (res % 2 == 0) return res;
        int ans = 0;
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if ((cards[i] & 1) == 0 && minOdd != Integer.MAX_VALUE) {
                ans = Math.max(ans, res - minOdd + cards[i]);
            } else if ((cards[i] & 1) == 1 && minEven != Integer.MAX_VALUE) {
                ans = Math.max(ans, res - minEven + cards[i]);
            }
        }
        return ans;
    }
}