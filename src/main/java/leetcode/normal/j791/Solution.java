package leetcode.normal.j791;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/custom-sort-string/">791. 自定义字符串排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String customSortString(String order, String s) {
        int[] vis = new int[26];
        for (int i = 0; i < order.length(); i++) {
            vis[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) chars[i] = s.charAt(i);
        Arrays.sort(chars, Comparator.comparingInt(ch -> vis[ch - 'a']));
        StringBuilder sb = new StringBuilder();
        for (Character aChar : chars) sb.append(aChar);
        return sb.toString();
    }
}