package leetcode.normal.j1156;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/">1156. 单字符重复子串的最大长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        for (int i = 0; i < text.length(); i++) cnt[text.charAt(i) - 'a']++;
        int ans = 1, i = 0, n = text.length();
        while (i < n) {
            // 先找到最大连续相同的区间，[i,j)
            int j = i + 1;
            while (j < n && text.charAt(i) == text.charAt(j)) j++;
            int curCnt = j - i;
            // 如果这个连续区间的长度小于对应字符的次数，并且不是开头或者末尾，那么可以交换一个位置使得长度更大
            int posChar = text.charAt(i) - 'a';
            if (curCnt < cnt[posChar] && (i > 0 || j < n)) {
                ans = Math.max(ans, curCnt + 1);
            }
            // 在找最大连续相同的下一个区间 [j+1,k)
            int k = j + 1;
            while (k < n && text.charAt(i) == text.charAt(k)) k++;
            // 第一个连续区间 + 不同字符 + 第二个连续区间 的长度不超过其字母的出现次数，可以计算出一共可以有多长
            ans = Math.max(ans, Math.min(k - i, cnt[posChar]));
            i = j;
        }
        return ans;
    }
}