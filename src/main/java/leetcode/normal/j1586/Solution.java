package leetcode.normal.j1586;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-search-tree-iterator-ii/description/">1586. 二叉搜索树迭代器 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class BSTIterator {
    ArrayDeque<TreeNode> stack;
    List<Integer> arr;
    TreeNode last;
    int pointer;

    public BSTIterator(TreeNode root) {
        last = root;
        stack = new ArrayDeque<>();
        arr = new ArrayList<>();
        pointer = -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || last != null || pointer < arr.size() - 1;
    }

    public int next() {
        ++pointer;
        // 如果当前指针到达末尾了，要计算下一个
        if (pointer == arr.size()) {
            // 中序遍历：先左节点，再右节点，最后当前节点
            // 先把左右节点入站
            while (last != null) {
                stack.push(last);
                last = last.left;
            }
            // 从栈顶取出当前节点
            TreeNode curr = stack.pop();
            // 下一次从右节点开始靠左
            last = curr.right;
            arr.add(curr.val);
        }
        return arr.get(pointer);
    }

    public boolean hasPrev() {
        return pointer > 0;
    }

    public int prev() {
        pointer = Math.max(0, pointer - 1);
        return arr.get(pointer);
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */