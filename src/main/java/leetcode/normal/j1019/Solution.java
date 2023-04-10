package leetcode.normal.j1019;

import javafx.util.Pair;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/next-greater-node-in-linked-list/">1019. 链表中的下一个更大节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayDeque<Pair<ListNode, Integer>> deque = new ArrayDeque<>();
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            ++len;
        }
        int i = 0;
        int[] ans = new int[len];
        while (head != null) {
            while (!deque.isEmpty() && deque.peek().getKey().val < head.val) {
                Pair<ListNode, Integer> pop = deque.pop();
                ans[pop.getValue()] = head.val;
            }
            deque.push(new Pair<>(head, i));
            i++;
            head = head.next;
        }
        return ans;
    }
}