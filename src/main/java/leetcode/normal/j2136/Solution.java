package leetcode.normal.j2136;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 * 面试题 17.10. 主要元素
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, mostNum = 0;
        for (int num : nums) {
            if (cnt == 0) mostNum = num;
            if (mostNum == num) ++cnt;
            else --cnt;
        }
        int mostCnt = 0;
        for (int num : nums) {
            if (mostNum == num) ++mostCnt;
        }
        if (mostCnt * 2 > nums.length) return mostNum;
        else return -1;
    }
}
