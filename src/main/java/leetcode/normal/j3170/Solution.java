package leetcode.normal.j3170;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars/description/">3170. 删除星号以后字典序最小的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String clearStars(String s) {
        ArrayList<Integer>[] lastIdx = new ArrayList[26];
        for (int i = 0; i < lastIdx.length; i++) {
            lastIdx[i] = new ArrayList<>();
        }
        boolean[] marked = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                int minIdx = findMinIdx(lastIdx);
                if (minIdx != -1) {
                    Integer idx = lastIdx[minIdx].get(lastIdx[minIdx].size() - 1);
                    marked[idx] = true;
                    lastIdx[minIdx].remove(lastIdx[minIdx].size() - 1);
                }
            } else {
                lastIdx[s.charAt(i) - 'a'].add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*' && !marked[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    int findMinIdx(ArrayList<Integer>[] lastIdx) {
        for (int i = 0; i < lastIdx.length; i++) {
            if (!lastIdx[i].isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}