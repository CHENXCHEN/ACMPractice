package leetcode.normal.j2336;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-number-in-infinite-set/">2336. 无限集中的最小数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class SmallestInfiniteSet {

    TreeSet<Integer> tSet;
    int minNum;

    public SmallestInfiniteSet() {
        tSet = new TreeSet<>();
        minNum = 1;
    }

    public int popSmallest() {
        if (tSet.isEmpty()) return minNum++;
        int ans = Math.min(minNum, tSet.first());
        if (ans == minNum) minNum++;
        tSet.remove(ans);
        return ans;
    }

    public void addBack(int num) {
        tSet.add(num);
    }
}