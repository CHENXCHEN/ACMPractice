package leetcode.normal.j1093;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/statistics-from-a-large-sample/">1093. 大样本统计</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double[] sampleStats(int[] count) {
        int left = 0, right = count.length - 1;
        while (left < right && count[left] == 0) left++;
        while (left < right && count[right] == 0) right--;
        long tot = 0, sum = 0;
        int most = left;
        for (int i = left; i <= right; i++) {
            tot += count[i];
            sum += (long) i * count[i];
            if (count[i] > count[most]) most = i;
        }
        double mean = 1.0 * sum / tot;
        int median1 = -1, median2 = -1;
        long cnt = 0;
        for (int i = left; i <= right; i++) {
            cnt += count[i];
            if (cnt >= (tot >> 1)) {
                if (median1 == -1) median1 = i;
            }
            if (cnt >= (tot >> 1) + 1) {
                if (median2 == -1) median2 = i;
            }
        }
        double median;
        if ((tot & 1) == 0) median = (median1 + median2) / 2.0;
        else median = median2;
        double[] ans = {left, right, mean, median, most};
        return ans;
    }
}