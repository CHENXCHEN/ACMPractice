package leetcode.normal.j142;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">142. 环形链表 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        // 令 a + b 为链表的长度，a 为环入口前的节点长度，b 为环的节点长度
        // 当快指针和慢指针相遇的时候，慢指针走了 s 个节点，快指针走了 f 个节点
        // 相遇时，可知两个公式
        // 1) f = 2s (快指针每次走两步)
        // 2) f = s + nb (当相遇时，fast 在环内比 slow 走多了整数倍的环长度)
        // 可知 => s = nb, f = 2nb
        // 入口一定是位于 a + nb，我们知道 slow 已经走过了 nb，只需要再走 a 步就可以找到入口了
        // 那么我们令新的 fast 为 head，当 fast 走了 a 步之后，slow 也会走到入口，fast = slow
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || slow != fast) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}