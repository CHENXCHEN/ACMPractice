package leetcode.normal.j2103;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rings-and-rods/description/">2103. 环和杆</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPoints(String rings) {
        int[] vis = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            int pos = rings.charAt(i + 1) - '0';
            if (rings.charAt(i) == 'R') {
                vis[pos] |= 1;
            } else if (rings.charAt(i) == 'G') {
                vis[pos] |= 2;
            } else {
                vis[pos] |= 4;
            }
        }
        int ans = 0;
        for (int vi : vis) {
            if (vi == 7) ans++;
        }
        return ans;
    }
}