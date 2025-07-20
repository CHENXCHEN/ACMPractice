package leetcode.normal.j1948;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/delete-duplicate-folders-in-system/description/">1948. 删除系统中的重复文件夹</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class TrieNode {
        String serial = "";
        TreeMap<String, TrieNode> children = new TreeMap<>();
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode cur = root;
            for (String node : path) {
                cur = cur.children.computeIfAbsent(node,x -> new TrieNode());
            }
        }
        TreeMap<String, Integer> freq = new TreeMap<>();
        dfsFreq(root, freq);
        List<List<String>> ans = new ArrayList<>();
        dfsSolve(root, new ArrayList<>(), ans, freq);
        return ans;
    }

    // 统计整颗数的每个节点出现频次
    void dfsFreq(TrieNode cur, TreeMap<String, Integer> freq) {
        if (cur.children.isEmpty()) return;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TrieNode> entry : cur.children.entrySet()) {
            dfsFreq(entry.getValue(), freq);
            sb.append(entry.getKey()).append('(').append(entry.getValue().serial).append(')');
        }
        cur.serial = sb.toString();
        freq.compute(sb.toString(), (k, v) -> v == null ? 1 : v + 1);
    }

    // 枚举这颗树的所有节点
    void dfsSolve(TrieNode cur, List<String> path, List<List<String>> ans, TreeMap<String, Integer> freq) {
        // 如果当前节点出现的频次 > 1，那么要标记删除的
        if (freq.getOrDefault(cur.serial, 0) > 1) return;
        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }
        for (Map.Entry<String, TrieNode> entry : cur.children.entrySet()) {
            path.add(entry.getKey());
            dfsSolve(entry.getValue(), path, ans, freq);
            path.remove(path.size() - 1);
        }
    }
}