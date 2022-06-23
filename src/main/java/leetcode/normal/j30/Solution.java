package leetcode.normal.j30;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * 30. 串联所有单词的子串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordCnt = words.length, wordLen = words[0].length(), totLen = wordLen * wordCnt;
        ArrayList<Integer> ans = new ArrayList<>();
        if (s.length() < totLen) return ans;
        TreeMap<String, Integer> tMap = new TreeMap<>();
        for (String word : words) tMap.put(word, tMap.getOrDefault(word, 0) + 1);
        TreeMap<String, Integer> vis = new TreeMap<>();
        for (int i = 0; i + totLen - 1 < s.length(); i++) {
            if (isConnect(s.substring(i, i + totLen), tMap, wordLen, wordCnt)) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean isConnect(String str, TreeMap<String, Integer> tMap, int wordLen, int wordCnt) {
        TreeMap<String, Integer> vis = new TreeMap<>();
        for (int i = 0; i < wordCnt; i++) {
            int start = i * wordLen;
            String sub = str.substring(start, start + wordLen);
            int cnt = vis.getOrDefault(sub, 0) + 1;
            vis.put(sub, cnt);
            if (cnt > tMap.getOrDefault(sub, 0)) return false;
        }
        return true;
    }
}