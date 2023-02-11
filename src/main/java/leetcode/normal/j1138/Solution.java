package leetcode.normal.j1138;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/alphabet-board-path/">1138. 字母板上的路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String alphabetBoardPath(String target) {
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        Map<Character, Pair<Integer, Integer>> cPos = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                cPos.put(board[i].charAt(j), new Pair<>(i, j));
            }
        }
        char[] dir = {'D', 'U', 'R', 'L'};
        Pair<Integer, Integer> cur = new Pair<>(0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            Pair<Integer, Integer> nextPos = cPos.get(ch);
            if (nextPos.equals(cur)) {
                sb.append('!');
            } else {
                int rowDir = nextPos.getKey() > cur.getKey() ? 0 : 1, colDir = nextPos.getValue() > cur.getValue() ? 2 : 3;
                int diffRow = Math.abs(nextPos.getKey() - cur.getKey()), diffCol = Math.abs(nextPos.getValue() - cur.getValue());
                // 特殊处理 z 这个位置
                if (ch == 'z') {
                    sb.append(repeat(dir[colDir], diffCol));
                    sb.append(repeat(dir[rowDir], diffRow));
                } else {
                    sb.append(repeat(dir[rowDir], diffRow));
                    sb.append(repeat(dir[colDir], diffCol));
                }
                sb.append('!');
                cur = nextPos;
            }
        }
        return sb.toString();
    }

    String repeat(char ch, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(ch);
        return sb.toString();
    }
}