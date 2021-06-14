package leetcode.normal.j374;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * 374. 猜数字大小
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long left = 1, right = n;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            // 如果 mid <= pick
            if (guess((int)mid)>=0) left = mid;
            else right = mid - 1;
        }
        return (int)left;
    }
}