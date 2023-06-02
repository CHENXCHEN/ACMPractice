package leetcode.normal.j2517;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/">2517. 礼盒的最大甜蜜度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] price;
    int k;

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        this.price = price;
        this.k = k;
        return (int) binarySearch();
    }

    long binarySearch() {
        long left = 0, right = price[price.length - 1] - price[0];
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (checkValid(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    boolean checkValid(long lag) {
        int cnt = 1, last = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= lag) {
                last = price[i];
                ++cnt;
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price = {13, 5, 1, 8, 21, 2};
        System.out.println(solution.maximumTastiness(price, 3));
    }
}