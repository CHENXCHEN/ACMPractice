package leetcode.normal.j68;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/text-justification/
 * 68. 文本左右对齐
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> ans = new LinkedList<>();
        while (i < words.length) {
            int j = i, len = 0;
            boolean check = true;
            while (check) {
                if (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                    len += words[j].length();
                    ++j;
                } else check = false;
            }
            String[] wordRange = Arrays.copyOfRange(words, i, j);
            if (j < words.length)
                ans.add(formatStr(wordRange, maxWidth - len));
            else
                ans.add(addSpaceToString(String.join(" ", wordRange), maxWidth - len - (j - i - 1)));
            i = j;
        }
        return ans;
    }

    String formatStr(String[] words, int space) {
        if (words.length == 1) return addSpaceToString(words[0], space);
        int firstAdd = space % (words.length - 1);
        int perSpace = space / (words.length - 1);
        String firstAddSpace = addSpaceToString("", perSpace + 1);
        String perWordSpace = addSpaceToString("", perSpace);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (firstAdd > 0) {
                sb.append(firstAddSpace);
                firstAdd--;
            } else if (i != words.length - 1) {
                sb.append(perWordSpace);
            }
        }
        return sb.toString();
    }

    String addSpaceToString(String s, int space) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < space; i++) sb.append(' ');
        return sb.toString();
    }
}