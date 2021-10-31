package leetcode.normal.j500;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/keyboard-row/
 * 500. 键盘行
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] getRows() {
        int[] ints = new int[3];
        String[] strs = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < strs.length; i++) {
            ints[i] = getBitMap(strs[i]);
        }
        return ints;
    }

    int getBitMap(String str) {
        int ans = 0;
        String lowerStr = str.toLowerCase();
        for (int i = 0; i < lowerStr.length(); i++) {
            ans |= 1 << (lowerStr.charAt(i) - 'a');
        }
        return ans;
    }

    boolean isContain(int[] rows, int n) {
        for (int row : rows) {
            if ((row & n) == n) return true;
        }
        return false;
    }

    public String[] findWords(String[] words) {
        ArrayList<String> array = new ArrayList<>();
        int[] rows = getRows();
        for (String word : words) {
            if (isContain(rows, getBitMap(word))) {
                array.add(word);
            }
        }
        return array.toArray(new String[0]);
    }
}