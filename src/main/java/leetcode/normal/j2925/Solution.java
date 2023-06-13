package leetcode.normal.j2925;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/4ueAj6/
 * 剑指 Offer II 029. 排序的循环链表
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node root = head;
        int circleCnt = 0;
        while (true) {
            if ((root.val <= insertVal && insertVal < root.next.val)
                    || (root.val > root.next.val && insertVal >= root.val)
                    || (root.val > root.next.val && insertVal <= root.next.val)
                    || (circleCnt == 1 && root.next == head)) {
                root.next = new Node(insertVal, root.next);
                break;
            } else if (root.next == head) circleCnt++;
            root = root.next;
        }
        return head;
    }
}