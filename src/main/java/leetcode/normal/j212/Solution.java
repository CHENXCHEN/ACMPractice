package leetcode.normal.j212;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/word-search-ii/
 * 212. 单词搜索 II
 *
 * @author <a href='mailto:chenhuachaoxyz@gmail.com'>报时</a>
 */
class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    boolean isWordWalk(char[][] board, String word, int x, int y, int step, boolean[][] visit) {
        if (step == word.length() - 1) return true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visit[nx][ny] && board[nx][ny] == word.charAt(step + 1)) {
                visit[nx][ny] = true;
                if (isWordWalk(board, word, nx, ny, step + 1, visit)) {
                    return true;
                }
                visit[nx][ny] = false;
            }
        }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        TreeMap<Integer, List<List<Integer>>> charToPos = new TreeMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int ch = board[i][j];
                List<List<Integer>> list = charToPos.getOrDefault(ch, new ArrayList<>());
                if (list.isEmpty()) charToPos.put(ch, list);
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(i);
                e.add(j);
                list.add(e);
            }
        }
        return Arrays.stream(words).filter(word -> {
            List<List<Integer>> posList = charToPos.getOrDefault((int) word.charAt(0), Collections.unmodifiableList(new ArrayList<>()));
            for (List<Integer> posXY : posList) {
                boolean[][] visit = new boolean[rows][cols];
                int x = posXY.get(0), y = posXY.get(1);
                visit[x][y] = true;
                if (isWordWalk(board, word, x, y, 0, visit)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }
}
