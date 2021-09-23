package leetcode.normal.j725;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * 725. 分隔链表
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode root = head;
        while (root != null) {
            len++;
            root = root.next;
        }
        int perPart = len / k;
        int mod = len % k;
        ListNode[] ans = new ListNode[k];
        root = head;
        for (int i = 0; i < k; i++) {
            ListNode tmp = root;
            int subLen = perPart;
            if (mod > 0) {
                subLen++;
                mod--;
            }
            while (subLen > 0 && root != null) {
                ListNode _tmp = root.next;
                if (subLen == 1) root.next = null;
                root = _tmp;
                subLen--;
            }
            ans[i] = tmp;
        }
        return ans;
    }
}
