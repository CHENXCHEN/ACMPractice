package leetcode.normal.j682;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/baseball-game/description/">682. 棒球比赛</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                Integer num1 = stack.poll();
                Integer num2 = stack.peek();
                stack.push(num1);
                stack.push(num1 + num2);
            } else if (operation.equals("D")) {
                Integer num1 = stack.peek();
                stack.push(num1 << 1);
            } else if (operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}