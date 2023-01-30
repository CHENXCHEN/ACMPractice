package leetcode.normal.j1669;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-in-between-linked-lists/">1669. 合并两个链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tmp = list1, first, second;
        --a;
        --b;
        // 先找到坐标 a 的前面一个位置
        while (a > 0) {
            tmp = tmp.next;
            --a;
            --b;
        }
        first = tmp;
        // 再找到坐标 b 的那个位置
        while (b >= 0) {
            tmp = tmp.next;
            --b;
        }
        second = tmp;
        tmp = list2;
        while (tmp.next != null) tmp = tmp.next;
        first.next = list2;
        tmp.next = second.next;
        return list1;
    }
}