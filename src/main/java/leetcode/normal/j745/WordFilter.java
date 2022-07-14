package leetcode.normal.j745;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/prefix-and-suffix-search/submissions/">745. 前缀和后缀搜索</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class WordFilter {
    static class DictNode {
        DictNode[] child = new DictNode[26];
        TreeSet<Integer> tSet = new TreeSet<>(Comparator.comparingInt(x -> -x));
    }

    DictNode prefixRoot = new DictNode(), suffixRoot = new DictNode();

    void insert(DictNode root, String str, int pos) {
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i) - 'a';
            if (root.child[now] == null) root.child[now] = new DictNode();
            root = root.child[now];
            root.tSet.add(pos);
        }
    }

    TreeSet<Integer> query(DictNode root, String str) {
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i) - 'a';
            if (root.child[now] == null) return null;
            root = root.child[now];
        }
        return root.tSet;
    }

    public WordFilter(String[] words) {
        TreeSet<String> vis = new TreeSet<>();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!vis.contains(words[i])) {
                insert(prefixRoot, words[i], i);
                insert(suffixRoot, reverseString(words[i]), i);
                vis.add(words[i]);
            }
        }
    }

    String reverseString(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) sb.append(str.charAt(i));
        return sb.toString();
    }

    public int f(String pref, String suff) {
        TreeSet<Integer> prefixSet = query(prefixRoot, pref);
        if (prefixSet == null) return -1;
        TreeSet<Integer> suffixSet = query(suffixRoot, reverseString(suff));
        if (suffixSet == null) return -1;
        for (Integer vv : prefixSet) {
            if (suffixSet.contains(vv)) {
                return vv;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // ["WordFilter","f"]
        //[[["abbba","abba"]],["ab","ba"]]
        String[] words = {"abbba", "abba"};
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f("ab", "ba"));
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */