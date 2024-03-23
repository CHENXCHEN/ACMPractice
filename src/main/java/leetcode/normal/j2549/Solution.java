package leetcode.normal.j2549;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-distinct-numbers-on-board/description/">2549. 统计桌面上的不同数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }
}
/**
 * 5
 * 2 4
 * 1 3
 * <p>
 * 10
 * 9 3
 * 8 4 2
 * 7 1
 * 6
 * 5
 */