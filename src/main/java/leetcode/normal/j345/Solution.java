package leetcode.normal.j345;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 345. 反转字符串中的元音字母
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        HashSet<Character> ss = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        while (l < r) {
            while (l < r && !ss.contains(Character.toLowerCase(s.charAt(l)))) ++l;
            while (l < r && !ss.contains(Character.toLowerCase(s.charAt(r)))) --r;
            if (l < r) {
                sb.setCharAt(l, s.charAt(r));
                sb.setCharAt(r, s.charAt(l));
                ++l;
                --r;
            }
        }
        return sb.toString();
    }
}
