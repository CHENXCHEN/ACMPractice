package leetcode.normal.j754;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reach-a-number/">754. 到达终点数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        // 先找到最小 k 使得 s=1+2+...+k >= target
        // d = target - s,
        // 如果 d 为偶数，使得 d/2 为负数即可满足等式，d/2 变为负数，可以使得总和 -d，手动模拟则可知
        // 如果 d 为奇数，那么要多走1或者2步
        //  则如果 d + k + 1 为偶数，那么答案为 k + 1，否则答案为 k + 2(d + k + 1 + k + 2 可以证明必然为偶数)
        //  可知，d 为奇数，若 k 为偶数，那么答案为 k + 1，否则答案为 k + 2
        return (target & 1) == 0 ? k : k + 1 + (k & 1);
    }
}