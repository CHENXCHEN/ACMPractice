package leetcode.normal.j575;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/distribute-candies/
 * 575. 分糖果
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distributeCandies(int[] candyType) {
        int num = 0;
        TreeSet<Integer> ss = new TreeSet<>();
        for (int _type : candyType) {
            ss.add(_type);
        }
        return Math.min(ss.size(), candyType.length >> 1);
    }
}
