package leetcode.normal.j134;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/gas-station/description/">134. 加油站</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; ) {
            int j = i, sumGas = 0, sumCost = 0, cnt = 0;
            while (cnt < n) {
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas < sumCost) break;
                j = (j + 1) % n;
                cnt++;
            }
            if (cnt == n) return i;
            else i += cnt + 1;
        }
        return -1;
    }
}