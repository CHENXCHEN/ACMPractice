package leetcode.normal.j275;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/h-index-ii/
 * 275. H 指数 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}