package leetcode.normal.j899;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/orderly-queue/">899. 有序队列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    static class TreeNode {
        TreeNode[] child;
        boolean isEnd;

        TreeNode() {
            child = new TreeNode[26];
            isEnd = false;
        }
    }

    void insert(TreeNode root, String str, int start, int end) {
        for (int i = start; i < end; i++) {
            int now = str.charAt(i) - 'a';
            if (root.child[now] == null) root.child[now] = new TreeNode();
            root = root.child[now];
        }
        root.isEnd = true;
    }

    String getMin(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        while (!root.isEnd) {
            for (int i = 0; i < 26; i++) {
                if (root.child[i] != null) {
                    sb.append((char) ('a' + i));
                    root = root.child[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        int len = s.length();
        String ss = s + s;
        TreeNode root = new TreeNode();
        for (int i = 0; i < len; i++) insert(root, ss, i, i + len);
        return getMin(root);
    }
}
