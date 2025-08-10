package leetcode.normal.j1166;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-file-system/description/">1166. 设计文件系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FileSystem {
    class TreeNode {
        int val;
        TreeMap<String, TreeNode> children = new TreeMap<>();

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode root;

    public FileSystem() {
        root = new TreeNode(0);
    }

    public boolean createPath(String path, int value) {
        String[] split = path.split("/");
        TreeNode cur = root;
        for (int i = 1; i < split.length - 1; i++) {
            if (split[i].isEmpty()) return false;
            cur = cur.children.get(split[i]);
            if (cur == null) return false;
        }
        String last = split[split.length - 1];
        if (cur.children.containsKey(last)) {
            return false;
        } else {
            cur.children.put(last, new TreeNode(value));
            return true;
        }
    }

    public int get(String path) {
        String[] split = path.split("/");
        TreeNode cur = root;
        for (int i = 1; i < split.length; i++) {
            if (split[i].isEmpty()) return -1;
            cur = cur.children.get(split[i]);
            if (cur == null) return -1;
        }
        return cur.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */