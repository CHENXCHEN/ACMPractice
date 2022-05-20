package leetcode.normal.j961;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] hash = new int[10000 + 1];
        for (int num : nums) {
            hash[num]++;
            if (hash[num] > 1) return num;
        }
        return 0;
    }
}