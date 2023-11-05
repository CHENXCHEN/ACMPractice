package leetcode.normal.j187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/repeated-dna-sequences/description/">187. 重复的DNA序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> vis = new HashMap<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            Integer subCnt = vis.getOrDefault(sub, 0);
            if (subCnt == 1) {
                ans.add(sub);
            }
            vis.put(sub, subCnt + 1);
        }
        return ans;
    }
}