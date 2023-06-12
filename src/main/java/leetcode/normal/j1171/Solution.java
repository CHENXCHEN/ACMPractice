package leetcode.normal.j1171;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">1171. 从链表中删去总和值为零的连续节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode root = new ListNode(0, head), cur = head;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        map.put(0, root);
        deque.push(0);
        // 计算前缀和，当前前缀和为 X，若 X 在计算前面节点的前缀和出现过的话，我们就可以知道这两个节点之间的节点都可删除
        // 删除前缀和后，前面出现的这些节点的前缀和都无效了，需要直接剔除
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                map.get(sum).next = cur.next;
                while (!deque.isEmpty() && deque.peek() != sum) {
                    map.remove(deque.poll());
                }
            } else {
                map.put(sum, cur);
                deque.push(sum);
            }
            cur = cur.next;
        }
        return root.next;
    }
}