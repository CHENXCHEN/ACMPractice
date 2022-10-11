package leetcode.normal.j817;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/linked-list-components/">817. 链表组件</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        boolean[] pos = new boolean[10001];
        for (int i = 0; i < nums.length; i++) pos[nums[i]] = true;
        int ans = 0;
        while (head != null) {
            boolean isComponent = false;
            while (head != null && pos[head.val]) {
                isComponent = true;
                head = head.next;
            }
            if (isComponent) {
                ++ans;
            }
            if (head != null) head = head.next;
        }
        return ans;
    }
}