package leetcode.normal.j679;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/24-game/description/">679. 24 点游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    final int target = 24;
    final double eps = 1e-6;

    public boolean judgePoint24(int[] cards) {
        ArrayList<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    boolean solve(ArrayList<Double> cards) {
        if (cards.isEmpty()) {
            return false;
        }
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - target) < eps;
        }
        int sz = cards.size();
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (i == j) continue;
                // 枚举任意两个数操作，然后加到卡片集合里进行下一次操作
                ArrayList<Double> detected = new ArrayList<>();
                for (int k = 0; k < sz; k++) {
                    if (i == k || j == k) continue;
                    detected.add(cards.get(k));
                }
                for (int k = 0; k < 4; k++) {
                    if (k == 0) {
                        detected.add(cards.get(i) + cards.get(j));
                    } else if (k == 1) {
                        detected.add(cards.get(i) - cards.get(j));
                    } else if (k == 2) {
                        detected.add(cards.get(i) * cards.get(j));
                    } else {
                        if (cards.get(j) > eps) {
                            detected.add(cards.get(i) / cards.get(j));
                        } else continue;
                    }
                    if (solve(detected)) {
                        return true;
                    }
                    detected.remove(detected.size() - 1);
                }
            }
        }
        return false;
    }
}