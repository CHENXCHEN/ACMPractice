package leetcode.normal.j846;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/hand-of-straights/
 * 846. 一手顺子
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        else {
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            for (int h : hand) {
                tMap.put(h, tMap.getOrDefault(h, 0) + 1);
            }
            int round = hand.length / groupSize;
            for (int i = 0; i < round; i++) {
                int head = tMap.navigableKeySet().first();
                tMap.put(head, tMap.get(head) - 1);
                if (tMap.get(head) == 0) tMap.remove(head);
                for (int j = 0; j < groupSize - 1; j++) {
                    head++;
                    if (tMap.containsKey(head)) {
                        tMap.put(head, tMap.get(head) - 1);
                        if (tMap.get(head) == 0) tMap.remove(head);
                    } else return false;
                }
            }
            return true;
        }
    }
}
