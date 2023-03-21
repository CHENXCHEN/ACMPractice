package leetcode.normal.j2469;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-the-temperature/">2469. 温度转换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}