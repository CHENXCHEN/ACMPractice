package leetcode.normal.j1739;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/building-boxes/description/">1739. 放置盒子</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumBoxes(int n) {
        int i = 1, cur = 1, j = 0;
        while (n >= cur) {
            n -= cur;
            cur += ++i;
        }
        cur = 0;
        while (n > cur) {
            n -= cur;
            ++cur;
            ++j;
        }
        return (((i - 1) * i) >> 1) + j;
    }
}