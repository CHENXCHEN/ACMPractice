package leetcode.normal.j2611;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/mice-and-cheese/">2611. 老鼠和奶酪</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // 最终结果一定为 sum(reward2) + delta，而 delta 为选择 reward1 的代价，如果选择了第 i 个，那么其增量为 reward1[i] - reward2[i]
        // 我们只需要对 reward1[i] - reward2[i] 的结果进行排序，取最大的 k 个即可
        int sum = Arrays.stream(reward2).sum();
        int[] diff = new int[reward1.length];
        for (int i = 0; i < diff.length; i++) diff[i] = reward1[i] - reward2[i];
        Arrays.sort(diff);
        for (int i = diff.length - k; i < diff.length; i++) {
            sum += diff[i];
        }
        return sum;
    }
}