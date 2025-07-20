package leetcode.normal.j527;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/word-abbreviation/description/">527. 单词缩写</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class TrieNode {
        int cnt = 0;
        TrieNode[] children = new TrieNode[26];
    }

    void insert(String word, TrieNode root) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            cur.cnt++;
        }
    }

    String findUniqPrefix(String word, TrieNode root) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            sb.append(c);
            cur = cur.children[idx];
            if (cur == null || cur.cnt == 1) break;
        }
        return sb.toString();
    }

    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, TrieNode> map = new HashMap<>();
        for (String word : words) {
            // 每个首+尾+长度相同的，作为一个特征，记录它的字典树
            String uniq = abbrev(word, 0);
            TrieNode root = map.computeIfAbsent(uniq, k -> new TrieNode());
            insert(word, root);
        }
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            String uniq = abbrev(word, 0);
            TrieNode root = map.get(uniq);
            String prefix = findUniqPrefix(word, root);
            int midLen = word.length() - prefix.length() - 1;
            String midStr = String.valueOf(midLen);
            if (prefix.length() + midStr.length() + 1 >= word.length()) ans.add(word);
            else ans.add(prefix + midStr + word.charAt(word.length() - 1));
        }
        return ans;
    }

    String abbrev(String word, int i) {
        int n = word.length();
        if (n - (i + 1) - 1 <= 1) return word;
        return word.substring(0, i + 1) + (n - i - 2) + word.charAt(n - 1);
    }
}