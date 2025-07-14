package leetcode.normal.j425;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/word-squares/description/">425. 单词方块</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int n = 0;
    String[] words;
    Map<String, List<String>> prefixWords;

    void buildPrefixWords(String[] words) {
        prefixWords = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String str = word.substring(0, i);
                prefixWords.computeIfAbsent(str, x -> new ArrayList<>()).add(word);
            }
        }
    }

    void backtracking(int step, List<String> wordSquares, List<List<String>> results) {
        if (step == n) {
            results.add(new ArrayList<>(wordSquares));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }
        for (String candidate : prefixWords.getOrDefault(prefix.toString(), new ArrayList<>())) {
            wordSquares.add(candidate);
            backtracking(step + 1, wordSquares, results);
            wordSquares.remove(wordSquares.size() - 1);
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        n = words[0].length();
        this.words = words;
        List<List<String>> results = new ArrayList<>();
        buildPrefixWords(words);
        for (String word : words) {
            ArrayList<String> wordSquares = new ArrayList<>();
            wordSquares.add(word);
            backtracking(1, wordSquares, results);
        }
        return results;
    }
}