package leetcode.normal.j1290;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/description/">1290. 二进制链表转整数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode pre = null;
        while (head != null) {
            if (pre != null) ans <<= 1;
            ans |= head.val;
            pre = head;
            head = head.next;
        }
        return ans;
    }
}