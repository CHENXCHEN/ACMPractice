package leetcode.normal.j833;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-and-replace-in-string/">833. 字符串中的查找与替换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), k = indices.length;
        Integer[] order = new Integer[k];
        for (int i = 0; i < k; i++) order[i] = i;
        Arrays.sort(order, Comparator.comparingInt(x -> indices[x]));
        for (int i = 0, j = 0; i < n; ) {
            if (j < k && i == indices[order[j]]) {
                if (cmp(s, sources[order[j]], i)) {
                    sb.append(targets[order[j]]);
                    i += sources[order[j]].length();
                } else {
                    sb.append(s.charAt(i++));
                }
                j++;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }

    Boolean cmp(String s, String e, int pos) {
        if (s.length() - pos < e.length()) return false;
        for (int i = pos, j = 0; i < s.length() && j < e.length(); i++, j++) {
            if (s.charAt(i) != e.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"});
    }
}