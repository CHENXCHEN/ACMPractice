package leetcode.normal.j278;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/first-bad-version/
 * 278. 第一个错误的版本
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1, r = n;
        while (l < r) {
            long m = (l + r) >> 1;
            if (isBadVersion((int) m)) r = m;
            else l = m + 1;
        }
        return (int) r;
    }
}