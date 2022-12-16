package leetcode.normal.j1785;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/">1785. 构成特定和需要添加的最少元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) sum += num;
        long delta = goal - sum;
        if (delta == 0) return 0;
        long abs = Math.abs(delta);
        return (int) (abs / limit + (abs % limit == 0 ? 0 : 1));
    }
}