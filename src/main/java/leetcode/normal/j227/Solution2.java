package leetcode.normal.j227;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-celebrity/description/">277. 搜寻名人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution2 extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (this.knows(candidate, i)) {
                candidate = i;
            }
        }
        return isCelebrity(candidate, n) ? candidate : -1;
    }

    boolean isCelebrity(int candidate, int n) {
        for (int i = 0; i < n; i++) {
            if (i != candidate && (this.knows(candidate, i) || !this.knows(i, candidate))) return false;
        }
        return true;
    }
}
