package leetcode.normal.j3306;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/">3306. 元音辅音字符串计数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long countOfSubstrings(String word, int k) {
        return count(word, k) - count(word, k + 1);
    }

    // 计算至少 >=k 的子串数有多少
    public long count(String word, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> map = new HashMap<>();
        int n = word.length(), cnt = 0, j = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (cnt < k || map.size() < 5)) {
                char ch = word.charAt(j);
                if (vowels.contains(ch)) {
                    map.compute(ch, (k1, v) -> v == null ? 1 : v + 1);
                } else {
                    cnt++;
                }
                j++;
            }
            if (cnt >= k && map.size() == 5) ans += n - j + 1;
            char left = word.charAt(i);
            if (vowels.contains(left)) {
                map.compute(left, (k1, v) -> v == 1 ? null : v - 1);
            } else {
                cnt--;
            }
        }
        return ans;
    }
}