package leetcode.normal.j2105;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/watering-plants-ii/description/">2105. 给植物浇水 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0, resA = capacityA, resB = capacityB, leftPos = 0, rightPos = plants.length - 1;
        while (leftPos <= rightPos) {
            if (leftPos == rightPos) {
                if (resA >= resB) {
                    if (resA < plants[leftPos]) ++ans;
                } else {
                    if (resB < plants[rightPos]) ++ans;
                }
                break;
            } else {
                resA -= plants[leftPos];
                if (resA < 0) {
                    resA = capacityA - plants[leftPos];
                    ++ans;
                }
                ++leftPos;
                resB -= plants[rightPos];
                if (resB < 0) {
                    resB = capacityB - plants[rightPos];
                    ++ans;
                }
                --rightPos;
            }
        }
        return ans;
    }
}