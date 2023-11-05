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
class Solution3 {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ans = new ArrayList<>();
        if (s.length() <= 10) return ans;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int mark = 0, mod = (1 << 20) - 1;
        for (int i = 0; i < 9; i++) mark = (mark << 2) | getCharMap(s.charAt(i));
        for (int i = 9; i < s.length(); i++) {
            mark = ((mark << 2) | getCharMap(s.charAt(i))) & mod;
            Integer subCnt = cnt.getOrDefault(mark, 0);
            if (subCnt == 1) ans.add(s.substring(i - 9, i + 1));
            cnt.put(mark, subCnt + 1);
        }
        return ans;
    }

    int getCharMap(char ch) {
        if (ch == 'A') return 0;
        if (ch == 'C') return 1;
        if (ch == 'G') return 2;
        return 3;
    }
}