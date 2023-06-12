package leetcode.normal.j1171;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">1171. 从链表中删去总和值为零的连续节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode root = new ListNode(0, head);
        for (ListNode cur = root; cur != null; cur = cur.next) {
            sum += cur.val;
            map.put(sum, cur);
        }
        // 第一次出现的前缀和和最后一次出现的前缀和，之间的节点都可以直接删除
        for (ListNode cur = root; cur != null; cur = cur.next) {
            sum += cur.val;
            cur.next = map.get(sum).next;
        }
        return root.next;
    }
}