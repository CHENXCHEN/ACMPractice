package leetcode.week.j293.j5234;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/
 * 5234. 移除字母异位词后的结果数组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(words[0]);
        String lastStr = words[0];
        for (int i = 1; i < words.length; i++) {
            if (!isSameStr(lastStr, words[i])) {
                arrayList.add(words[i]);
                lastStr = words[i];
            }
        }
        return arrayList;
    }

    boolean isSameStr(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
}