package leetcode.normal.j3442;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-i/description/">3442. 奇偶频次间的最大差值 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDifference(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int oddCnt = Integer.MIN_VALUE, evenCnt = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            if (cnt[i] % 2 == 1) {
                oddCnt = Math.max(oddCnt, cnt[i]);
            } else {
                evenCnt = Math.min(evenCnt, cnt[i]);
            }
        }
        return oddCnt - evenCnt;
    }
}