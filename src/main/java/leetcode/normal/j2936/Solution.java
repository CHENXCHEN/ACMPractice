package leetcode.normal.j2936;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-longest-subarray-lcci/">面试题 17.05.  字母与数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public String[] findLongestSubarray(String[] array) {
        int n = array.length, ss = 0, ans = 0, ansPos = 0;
        Map<Integer, Integer> tMap = new HashMap<>();
        tMap.put(0, -1);
        // 如果 array[i] 为数字，则令 s[i] = 1，否则令 s[i] = -1;
        // 找到最大的区间，使得这个s[...]子区间和结果为 0，用哈希记录
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(array[i].charAt(0))) ++ss;
            else --ss;
            Integer neg = tMap.get(ss);
            if (neg != null) {
                if (i - neg > ans) {
                    ans = i - neg;
                    ansPos = neg + 1;
                }
            }
            tMap.putIfAbsent(ss, i);
        }
        String[] ansStr = new String[ans];
        if (ans == 0) {
            return ansStr;
        }
        for (int i = 0; i < ans; i++) {
            ansStr[i] = array[i + ansPos];
        }
        return ansStr;
    }

    public static void main(String[] args) {
        String[] ss = {"42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d", "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"};
        Solution solution = new Solution();
        String[] longestSubarray = solution.findLongestSubarray(ss);
        System.out.println(Arrays.asList(longestSubarray));
    }
}