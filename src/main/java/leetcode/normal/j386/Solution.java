package leetcode.normal.j386;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographical-numbers/description/">386. 字典序排数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        ans.sort((x, y) -> String.valueOf(x).compareTo(String.valueOf(y)));
        return ans;
    }
}