package leetcode.normal.j2566;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-difference-by-remapping-a-digit/description/">2566. 替换一个数字后的最大差值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMaxDifference(int num) {
        int minNum = num, maxNum = num;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) continue;
                int res = trans(num, i, j);
                minNum = Math.min(minNum, res);
                maxNum = Math.max(maxNum, res);
            }
        }
        return maxNum - minNum;
    }

    int trans(int num, int from, int to) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            int cur = sb.charAt(i) - '0';
            if (cur == from) {
                sb.setCharAt(i, (char) ('0' + to));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}