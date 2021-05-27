package leetcode.normal.j461;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/hamming-distance/
 * 461. 汉明距离
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z > 0) {
            cnt += 1;
            z = z & (z - 1);
        }
        return cnt;
    }
}
