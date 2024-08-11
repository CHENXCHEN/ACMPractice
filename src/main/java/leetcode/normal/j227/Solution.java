package leetcode.normal.j227;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-celebrity/description/">277. 搜寻名人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] knowOther = new boolean[n];
        int[] beKnow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (knows(i, j)) {
                    beKnow[j]++;
                    knowOther[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!knowOther[i] && beKnow[i] == n - 1) return i;
        }
        return -1;
    }
}