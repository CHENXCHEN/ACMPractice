package leetcode.normal.j1733;

import java.util.BitSet;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-people-to-teach/description/">1733. 需要教语言的最少人数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        BitSet[] lanSet = new BitSet[m + 1];
        for (int i = 0; i < languages.length; i++) {
            lanSet[i + 1] = new BitSet();
            for (int j = 0; j < languages[i].length; j++) {
                lanSet[i + 1].set(languages[i][j]);
            }
        }
        // 找到不能相互沟通的好友，然后教他们同一种语言
        // 教他们这些不能相互沟通的好友中掌握最多的一种语言
        TreeSet<Integer> notMatched = new TreeSet<>();
        for (int[] e : friendships) {
            BitSet uSet = lanSet[e[0]];
            BitSet vSet = lanSet[e[1]];
            if (!uSet.intersects(vSet)) {
                notMatched.add(e[0]);
                notMatched.add(e[1]);
            }
        }
        int[] cnt = new int[n + 1];
        int mxCnt = 0;
        for (Integer u : notMatched) {
            for (int lan : languages[u - 1]) {
                cnt[lan]++;
                mxCnt = Math.max(mxCnt, cnt[lan]);
            }
        }
        return notMatched.size() - mxCnt;
    }
}