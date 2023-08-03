package leetcode.normal.j722;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-comments/">722. 删除注释</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> removeComments(String[] source) {
        boolean cType1 = false, cType2 = false;
        List<String> ans = new ArrayList<>();
        int row = 0, col = 0;
        StringBuilder sb = new StringBuilder();
        while (row < source.length) {
            String line = source[row];
            while (col < line.length()) {
                if (cType2) {
                    if (col + 1 < line.length() && line.charAt(col) == '*' && line.charAt(col + 1) == '/') {
                        col += 2;
                        cType2 = false;
                    } else {
                        col++;
                    }
                } else if (col + 1 < line.length()) {
                    if (line.charAt(col) == '/' && line.charAt(col + 1) == '/') {
                        cType1 = true;
                        break;
                    } else if (line.charAt(col) == '/' && line.charAt(col + 1) == '*') {
                        cType2 = true;
                        col += 2;
                    } else {
                        sb.append(line.charAt(col++));
                    }
                } else {
                    sb.append(line.charAt(col++));
                }
            }
            if (!cType2 && sb.length() > 0) {
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
            ++row;
            col = 0;
        }
        return ans;
    }
}