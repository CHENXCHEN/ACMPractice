package leetcode.normal.j1953;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long numberOfWeeks(int[] milestones) {
        long longest = milestones[0], rest = 0;
        for (int milestone : milestones) {
            longest = Math.max(milestone, longest);
            rest += milestone;
        }
        rest -= longest;
        return longest <= rest + 1 ? longest + rest : ((rest << 1) | 1);
    }
}