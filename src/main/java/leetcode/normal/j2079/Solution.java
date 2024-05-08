package leetcode.normal.j2079;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/watering-plants/description/">2079. 给植物浇水</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int cur = capacity, step = 0;
        for (int i = 0; i < plants.length; i++) {
            step++;
            if (cur < plants[i]) {
                cur = capacity - plants[i];
                step += i << 1;
            } else {
                cur -= plants[i];
            }
        }
        return step;
    }
}