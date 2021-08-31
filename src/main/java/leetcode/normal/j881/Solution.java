package leetcode.normal.j881;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * 881. 救生艇
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ll = 0, rr = people.length - 1;
        int ans = 0;
        while (ll <= rr) {
            ans += 1;
            if (people[ll] + people[rr] <= limit) {
                ll++;
                rr--;
            } else {
                rr--;
            }
        }
        return ans;
    }
}