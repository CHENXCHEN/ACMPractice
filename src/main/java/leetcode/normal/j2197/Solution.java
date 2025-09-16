package leetcode.normal.j2197;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/replace-non-coprime-numbers-in-array/description/">2197. 替换数组中的非互质数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            res.add(nums[i]);
            while (res.size() >= 2) {
                int last0 = res.get(res.size() - 1);
                int last1 = res.get(res.size() - 2);
                long gcd = (long) getGcd(last0, last1);
                if (gcd > 1) {
                    res.remove(res.size() - 1);
                    res.remove(res.size() - 1);
                    res.add((int) ((long) last0 * last1 / gcd));
                } else break;
            }
        }
        return res;
    }

    int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }
}