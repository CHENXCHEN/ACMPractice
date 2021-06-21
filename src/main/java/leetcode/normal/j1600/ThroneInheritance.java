package leetcode.normal.j1600;

import java.util.*;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/throne-inheritance/
 * 1600. 皇位继承顺序
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */

class ThroneInheritance {

    static class TreeNode {
        public String name;
        public ArrayList<TreeNode> child;

        TreeNode(String name, ArrayList<TreeNode> child) {
            this.name = name;
            this.child = child;
        }
    }

    Map<String, TreeNode> nameTreeNode = new TreeMap<>();
    Set<String> dSet = new TreeSet<>();
    String kingName;

    public TreeNode getTreeNodeByName(String name) {
        if (!nameTreeNode.containsKey(name)) {
            nameTreeNode.put(name, new TreeNode(name, new ArrayList<>()));
        }
        return nameTreeNode.get(name);
    }

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        getTreeNodeByName(kingName);
    }

    public void birth(String parentName, String childName) {
        getTreeNodeByName(parentName).child.add(getTreeNodeByName(childName));
    }

    public void death(String name) {
        dSet.add(name);
    }

    public List<String> traverTreeNode(TreeNode treeNode) {
        ArrayList<String> v = new ArrayList<>();
        if (!dSet.contains(treeNode.name)) {
            v.add(treeNode.name);
        }
        for (int i = 0; i < treeNode.child.size(); i++) {
            v.addAll(traverTreeNode(treeNode.child.get(i)));
        }
        return v;
    }

    public List<String> getInheritanceOrder() {
        return traverTreeNode(getTreeNodeByName(kingName));
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */