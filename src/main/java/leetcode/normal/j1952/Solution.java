package leetcode.normal.j1952;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rearrange-spaces-between-words/">1592. 重新排列单词间的空格</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String reorderSpaces(String text) {
        int spaceCnt = 0, wordCnt = 0;
        ArrayList<String> word = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCnt++;
                if (sb.length() > 0) {
                    word.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(text.charAt(i));
            }
        }
        if (sb.length() > 0) word.add(sb.toString());
        wordCnt = word.size();
        if (wordCnt == 1) {
            return word.get(0) + getSpaceStr(spaceCnt);
        } else {
            int wordSpace = spaceCnt / (wordCnt - 1);
            int leftSpace = spaceCnt - wordSpace * (wordCnt - 1);
            return String.join(getSpaceStr(wordSpace), word) + getSpaceStr(leftSpace);
        }
    }

    String getSpaceStr(int k) {
        char[] chars = new char[k];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }
}