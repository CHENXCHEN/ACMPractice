package leetcode.normal.j1773;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-items-matching-a-rule/">1773. 统计匹配检索规则的物品数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int keyPos = 0;
        if (ruleKey.equals("color")) keyPos = 1;
        else if (ruleKey.equals("name")) keyPos = 2;
        int ans = 0;
        for (List<String> item : items) {
            if (item.get(keyPos).equals(ruleValue)) ans++;
        }
        return ans;
    }
}