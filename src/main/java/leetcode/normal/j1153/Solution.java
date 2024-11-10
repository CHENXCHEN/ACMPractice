package leetcode.normal.j1153;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/string-transforms-into-another-string/description/">1153. 字符串转化</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        // 分类讨论
        //  1. 如果str1中一个字符映射到多个字符，那么一定不可能
        //  2. 如果str2的字母数为 26，一定不可能
        int[] mp = new int[26];
        Arrays.fill(mp, -1);
        int mask = 0;
        for (int i = 0; i < str1.length(); i++) {
            int pos1 = str1.charAt(i) - 'a';
            int pos2 = str2.charAt(i) - 'a';
            mask |= (1 << pos2);
            if (mp[pos1] == -1) {
                mp[pos1] = pos2;
            }
            if (mp[pos1] != pos2) return false;
        }
        return Integer.bitCount(mask) < 26;
    }
}