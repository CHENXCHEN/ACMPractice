package leetcode.normal.j1298;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-candies-you-can-get-from-boxes/description/">1298. 你能从盒子里获得的最大糖果数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] touchedBoxes = new boolean[n];
        TreeSet<Integer> openedBoxes = new TreeSet<>(), closedBoxes = new TreeSet<>();
        for (int initialBox : initialBoxes) {
            if (status[initialBox] == 1) openedBoxes.add(initialBox);
            else closedBoxes.add(initialBox);
        }
        while (!openedBoxes.isEmpty()) {
            Integer box = openedBoxes.pollFirst();
            status[box] = 1;
//            System.out.println("open box: " + box);
            touchedBoxes[box] = true;
            for (int key : keys[box]) {
                status[key] = 1;
                if (closedBoxes.contains(key)) {
                    openedBoxes.add(key);
                    closedBoxes.remove(key);
                }
            }
            for (int containedBox : containedBoxes[box]) {
                if (status[containedBox] == 1) openedBoxes.add(containedBox);
                else closedBoxes.add(containedBox);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (touchedBoxes[i] && status[i] == 1) {
                ans += candies[i];
            }
        }
        return ans;
    }
}