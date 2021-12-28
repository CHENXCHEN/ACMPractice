package leetcode.normal.j472;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/concatenated-words/
 * 472. 连接词
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class TreeNode {
        public TreeNode[] child = new TreeNode[26];
        public boolean isEnd = false;
    }

    void insert(TreeNode head, String word) {
        TreeNode next = head;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (next.child[pos] == null) {
                next.child[pos] = new TreeNode();
            }
            next = next.child[pos];
        }
        next.isEnd = true;
    }

    boolean query(TreeNode head, String word, int start) {
        if (word.length() == start) return true;
        // 可以对 start 判断，做一层记忆化搜索的优化
        TreeNode next = head;
        for (int i = start; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            next = next.child[pos];
            if (next == null) return false;
            if (next.isEnd) {
                if (query(head, word, i + 1)) return true;
            }
        }
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        TreeNode head = new TreeNode();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                if (query(head, words[i], 0)) ans.add(words[i]);
                else insert(head, words[i]);
            }
        }
        return ans;
    }
}