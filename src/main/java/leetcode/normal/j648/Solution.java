package leetcode.normal.j648;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/replace-words/">648. 单词替换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class TreeNode {
        TreeNode[] child = new TreeNode[26];
        boolean isEnd = false;

        TreeNode() {
        }
    }

    void insert(TreeNode root, String str) {
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            if (root.child[ch] == null) root.child[ch] = new TreeNode();
            root = root.child[ch];
        }
        root.isEnd = true;
    }

    String find(TreeNode root, String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length() && root != null; i++) {
            int ch = str.charAt(i) - 'a';
            sb.append(str.charAt(i));
            root = root.child[ch];
            if (root != null && root.isEnd) return sb.toString();
        }
        return str;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TreeNode root = new TreeNode();
        for (String s : dictionary) {
            insert(root, s);
        }
        String[] ss = sentence.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < ss.length; i++) {
            if (i != 0) ans.append(' ');
            ans.append(find(root, ss[i]));
        }
        return ans.toString();
    }
}