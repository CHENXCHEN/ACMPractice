package leetcode.normal.j771;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/jewels-and-stones/">771. 宝石与石头</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] vis = new boolean[255];
        for (int i = 0; i < jewels.length(); i++) {
            vis[jewels.charAt(i)] = true;
        }
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (vis[stones.charAt(i)]) ++ans;
        }
        return ans;
    }
}