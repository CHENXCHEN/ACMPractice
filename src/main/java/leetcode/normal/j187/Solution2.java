package leetcode.normal.j187;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/repeated-dna-sequences/description/">187. 重复的DNA序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ans = new ArrayList<>();
        root = new TreeNode();
        for (int i = 0; i + 9 < s.length(); i++) {
            if (addNode(s, i, i + 10) == 2) {
                ans.add(s.substring(i, i + 10));
            }
        }
        return ans;
    }

    class TreeNode {
        TreeNode[] child = new TreeNode[4];
        int cnt = 0;
    }

    TreeNode root;

    int addNode(String s, int start, int end) {
        TreeNode head = root;
        for (int i = start; i < end; i++) {
            int pos = getCharMap(s.charAt(i));
            if (head.child[pos] == null) head.child[pos] = new TreeNode();
            head = head.child[pos];
        }
        return ++head.cnt;
    }

    int getCharMap(char ch) {
        if (ch == 'A') return 0;
        if (ch == 'C') return 1;
        if (ch == 'G') return 2;
        return 3;
    }
}