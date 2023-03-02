package leetcode.unkown.j1;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/bianry-number-to-string-lcci/">面试题 05.02. 二进制数转字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double s = 0.5;
        int cnt = 0;
        while (num > 0) {
            ++cnt;
            if (cnt > 6) {
                return "ERROR";
            }
            if (num >= s) {
                num -= s;
                sb.append('1');
            } else {
                sb.append('0');
            }
            s /= 2;
        }
        if (num == 0) return sb.toString();
        else return "ERROR";
    }
}