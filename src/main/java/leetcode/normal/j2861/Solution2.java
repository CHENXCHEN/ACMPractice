package leetcode.normal.j2861;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-alloys/description/">2861. 最大合金数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    List<Integer> stock, cost;
    List<List<Integer>> composition;
    int budget, n, k;

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        this.budget = budget;
        this.n = n;
        this.stock = stock;
        this.cost = cost;
        this.k = k;
        this.composition = composition;
        int ans = 0, left = 1, right = 200000000;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (checkComposition(mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean checkComposition(int cnt) {
        for (int i = 0; i < k; i++) {
            if (checkBuild(cnt, composition.get(i))) return true;
        }
        return false;
    }

    boolean checkBuild(int cnt, List<Integer> rates) {
        int perCost = 0;
        for (int i = 0; i < n; i++) {
            perCost += rates.get(i) * cost.get(i);
        }
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