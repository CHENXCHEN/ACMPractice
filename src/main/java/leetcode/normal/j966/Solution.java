package leetcode.normal.j966;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/vowel-spellchecker/description/">966. 元音拼写检查器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> originSet = new HashSet<>();
        Map<String, Integer> inSensMap = new HashMap<>();
        Map<String, Integer> vowelMap = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            originSet.add(wordlist[i]);
            String lowerString = wordlist[i].toLowerCase();
            if (!inSensMap.containsKey(lowerString)) {
                inSensMap.put(lowerString, i);
            }
            String vowelString = lowerString.replaceAll("(a|e|i|o|u)", "@");
            if (!vowelMap.containsKey(vowelString)) {
                vowelMap.put(vowelString, i);
            }
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String lowerString = queries[i].toLowerCase();
            Integer lowerIdx = inSensMap.get(lowerString);
            String vowelString = lowerString.replaceAll("(a|e|i|o|u)", "@");
            Integer vowelIdx = vowelMap.get(vowelString);
            if (originSet.contains(queries[i])) {
                result[i] = queries[i];
            }
            else if (lowerIdx != null) {
                result[i] = wordlist[lowerIdx];
            } else if (vowelIdx != null) {
                result[i] = wordlist[vowelIdx];
            } else result[i] = "";
        }
        return result;
    }
}