package leetcode.normal.j676;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/implement-magic-dictionary/">676. 实现一个魔法字典</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MagicDictionary {
    static class DictNode {
        DictNode[] child = new DictNode[26];
        boolean isEnd = false;
    }

    DictNode root = new DictNode();

    void insert(String str, DictNode root) {
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i) - 'a';
            if (root.child[now] == null) root.child[now] = new DictNode();
            root = root.child[now];
        }
        root.isEnd = true;
    }

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            insert(str, root);
        }
    }

    boolean query(String str, DictNode root, int startPos, boolean isFirst) {
        for (int i = startPos; i < str.length(); i++) {
            int now = str.charAt(i) - 'a';
            if (isFirst) {
                // 替换当前字符看看
                for (int j = 0; j < 26; j++) {
                    if (j != now && root.child[j] != null && query(str, root.child[j], i + 1, false)) {
                        return true;
                    }
                }
            }
            if (root.child[now] == null) return false;
            root = root.child[now];
        }
        if (isFirst) return false;
        return root.isEnd;
    }

    public boolean search(String searchWord) {
        return query(searchWord, root, 0, true);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */