package leetcode.normal.j2785;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-vowels-in-a-string/description/">2785. 将字符串中的元音字母排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char lowerCase = Character.toLowerCase(s.charAt(i));
            if (lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u') {
                vowels.add(s.charAt(i));
                idx.add(i);
            }
        }
        vowels.sort((x, y) -> x - y);
        for (int i = 0; i < idx.size(); i++) {
            sb.setCharAt(idx.get(i), vowels.get(i));
        }
        return sb.toString();
    }
}