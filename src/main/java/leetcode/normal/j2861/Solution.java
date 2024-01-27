package leetcode.normal.j2861;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-alloys/description/">2861. 最大合金数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<Integer> stock, cost;
    int budget, n;

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        this.budget = budget;
        this.n = n;
        this.stock = stock;
        this.cost = cost;
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, evaluate(composition.get(i)));
        }
        return ans;
    }

    int evaluate(List<Integer> rates) {
        int ans = 0, left = 1, right = budget;
        int perCost = 0;
        for (int i = 0; i < n; i++) {
            perCost += rates.get(i) * cost.get(i);
            right += stock.get(i) / rates.get(i) + 1;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (checkBuild(mid, perCost, rates)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean checkBuild(int cnt, int perCost, List<Integer> rates) {
        long res = (long) perCost * cnt;
        for (int i = 0; i < n; i++) {
            if (stock.get(i) > 0) {
                int leave = stock.get(i) / rates.get(i);
                if (leave >= cnt) {
                    res -= (long) cnt * rates.get(i) * cost.get(i);
                } else {
                    res -= (long) stock.get(i) * cost.get(i);
                }
            }
        }
        return res <= budget;
    }
}