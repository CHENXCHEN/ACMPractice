package leetcode.normal.j3516;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-closest-person/description/">3516. 找到最近的人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findClosest(int x, int y, int z) {
        int dis1 = Math.abs(x - z), dis2 = Math.abs(y - z);
        if (dis1 < dis2) return 1;
        else if (dis1 > dis2) return 2;
        else return 0;
    }
}