package leetcode.normal.j1333;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/filter-restaurants-by-vegan-friendly-price-and-distance/description/">1333. 餐厅过滤器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            int[] restaurant = restaurants[i];
            boolean check = true;
            if (veganFriendly == 1 && restaurant[2] == 0) check = false;
            else if (restaurant[3] > maxPrice) check = false;
            else if (restaurant[4] > maxDistance) check = false;
            if (check) list.add(i);
        }
        list.sort((a, b) -> restaurants[a][1] != restaurants[b][1] ? Integer.compare(restaurants[b][1], restaurants[a][1]) : Integer.compare(restaurants[b][0], restaurants[a][0]));
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer idx : list) ans.add(restaurants[idx][0]);
        return ans;
    }
}