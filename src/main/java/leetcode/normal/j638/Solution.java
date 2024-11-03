package leetcode.normal.j638;

import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shopping-offers/description/">638. 大礼包</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] dp;
    List<Integer> price;
    List<List<Integer>> special;
    int n, maxNeed;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = needs.size(), maxNeed = needs.stream().max(Integer::compareTo).get();
        this.n = n;
        this.maxNeed = maxNeed;
        this.price = price;
        this.special = special;
        int maxStat = 0;
        for (int i = n - 1, j = 0; j < n; i--, j++) {
            maxStat = maxStat * (maxNeed + 1) + needs.get(i);
        }
        // dp[i] 表示当前集合为 i 时的最小花费，集合 i 表示为 第 1...n 件商品分别有 x 件时的状态
        // 把状态 i 拆分为一个长度为 n 的数组 a[0...n-1]，表示当前有多少件
        // 令 i = a[0...n-1]
        // 当前状态由买单个 x 商品转移所得 dp[i] = dp[i'] + price[x], i' 属于 a[x] - 1
        // 当前状态由买单个大礼包转移所得 dp[i] = dp[i'] + special[x][n], i' 属于 i 减去大礼包中的商品件数
        dp = new int[maxStat + 1];
        Arrays.fill(dp, -1);
        return dfs(maxStat);
    }

    int dfs(int stat) {
        if (stat == 0) return 0;
        int[] item = extractItem(stat);
//        System.out.println("stat: " + stat + " item: " + Arrays.toString(item));
        if (dp[stat] >= 0) return dp[stat];
        int cur = Integer.MAX_VALUE;
        // 当前状态由购买某件商品转移所得
        for (int i = 0; i < n; i++) {
            if (item[i] > 0) {
                item[i]--;
                int nStat = compressItem(item);
                cur = Math.min(cur, dfs(nStat) + price.get(i));
                item[i]++;
            }
        }
        // 当前状态由购买某个大礼包转移所得
        for (List<Integer> spec : special) {
            int specPrice = spec.get(spec.size() - 1);
            if (checkValidSpec(spec, item)) {
                int nStat = compressItem(item);
                cur = Math.min(cur, dfs(nStat) + specPrice);
            }
            reverseFromSpec(spec, item);
        }
        dp[stat] = cur;
        return dp[stat];
    }

    boolean checkValidSpec(List<Integer> spec, int[] item) {
        boolean check = true;
        for (int i = 0; i < n; i++) {
            item[i] -= spec.get(i);
            check &= item[i] >= 0;
        }
        return check;
    }

    void reverseFromSpec(List<Integer> spec, int[] item) {
        for (int i = 0; i < n; i++) {
            item[i] += spec.get(i);
        }
    }

    int[] extractItem(int stat) {
        int[] res = new int[n];
        for (int i = n - 1, j = 0; j < n; i--, j++) {
            res[j] = stat % (maxNeed + 1);
            stat /= maxNeed + 1;
        }
        return res;
    }

    int compressItem(int[] item) {
        int res = 0;
        for (int i = n - 1, j = 0; j < n; i--, j++) {
            res = res * (maxNeed + 1) + item[i];
        }
        return res;
    }
}