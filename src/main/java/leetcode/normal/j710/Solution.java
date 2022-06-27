package leetcode.normal.j710;

import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/random-pick-with-blacklist/
 * 710. 黑名单中的随机数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeMap<Integer, Integer> tMap;
    Random random;

    int left;

    public Solution(int n, int[] blacklist) {
        tMap = new TreeMap<>();
        random = new Random();
        int m = blacklist.length;
        left = n - m;
        TreeSet<Integer> rightSet = new TreeSet<>();
        for (int i = left; i < n; i++) rightSet.add(i);
        for (int black : blacklist) {
            if (black >= left) rightSet.remove(black);
        }
        for (int black : blacklist) {
            if (black < left) {
                tMap.put(black, rightSet.pollFirst());
            }
        }
    }

    public int pick() {
        int now = random.nextInt(left);
        return tMap.getOrDefault(now, now);
    }
}