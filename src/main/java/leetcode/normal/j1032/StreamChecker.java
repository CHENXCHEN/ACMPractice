package leetcode.normal.j1032;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/stream-of-characters/">1032. 字符流</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class StreamChecker {
    class TreeNode {
        TreeNode[] child = new TreeNode[26];
        boolean isEnd = false;
    }

    TreeNode root = new TreeNode();
    int maxLen = 0;

    void insertTree(String word) {
        TreeNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int now = word.charAt(i) - 'a';
            if (cur.child[now] == null) cur.child[now] = new TreeNode();
            cur = cur.child[now];
        }
        cur.isEnd = true;
    }

    boolean queryTree() {
        TreeNode cur = root;
        for (int i = sb.length() - 1, j = 0; i >= 0 && j < maxLen; i--, j++) {
            int now = sb.charAt(i) - 'a';
            if (cur.child[now] == null) return false;
            cur = cur.child[now];
            if (cur.isEnd) return true;
        }
        return false;
    }


    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) {
            insertTree(word);
            maxLen = Math.max(maxLen, word.length());
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return queryTree();
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd"});
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */