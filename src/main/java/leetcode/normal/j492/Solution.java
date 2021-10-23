package leetcode.normal.j492;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 * 492. 构造矩形
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] constructRectangle(int area) {
        int maxAns = (int) Math.sqrt(area);
        int[] ans = new int[2];
        ans[0] = 0;
        while (ans[0] == 0) {
            if (area % maxAns == 0) {
                ans[1] = maxAns;
                ans[0] = area / maxAns;
            }
            maxAns--;
        }
        return ans;
    }
}