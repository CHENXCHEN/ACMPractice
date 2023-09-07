package leetcode.normal.j2651;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/calculate-delayed-arrival-time/">2651. 计算列车到站时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}