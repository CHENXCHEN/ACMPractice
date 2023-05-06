package leetcode.normal.j1419;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-frogs-croaking/">1419. 数青蛙</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) return -1;
        int tot = 0, ans = 0;
        String frogSingle = "croak";
        int[] alreadyHad = new int[5];
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            int pos = frogSingle.indexOf(ch);
            if (pos == 0) {
                ++tot;
                alreadyHad[0]++;
                ans = Math.max(ans, tot);
            } else if (alreadyHad[pos - 1] == 0) {
                return -1;
            } else {
                alreadyHad[pos - 1]--;
                alreadyHad[pos]++;
                if (pos == 4) {
                    --tot;
                }
            }
        }
        if (tot != 0) return -1;
        return ans;
    }
}