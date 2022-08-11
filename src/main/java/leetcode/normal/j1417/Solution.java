package leetcode.normal.j1417;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reformat-the-string/">1417. 重新格式化字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String reformat(String s) {
        StringBuilder nums = new StringBuilder();
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) nums.append(s.charAt(i));
            else chars.append(s.charAt(i));
        }
        if (Math.abs(chars.length() - nums.length()) > 1) return "";
        if (nums.length() == 0) return chars.toString();
        if (chars.length() == 0) return nums.toString();
        int numPos = 0;
        int charPos = 0;
        boolean isNumFirst = true;
        StringBuilder ans = new StringBuilder();
        if (chars.length() > nums.length()) {
            ans.append(chars.charAt(charPos++));
        } else if (chars.length() < nums.length()) {
            isNumFirst = false;
            ans.append(nums.charAt(numPos++));
        }
        while (numPos < nums.length() || charPos < chars.length()) {
            if (isNumFirst && numPos < nums.length())
                ans.append(nums.charAt(numPos++));
            if (charPos < chars.length())
                ans.append(chars.charAt(charPos++));
            if (!isNumFirst && numPos < nums.length())
                ans.append(nums.charAt(numPos++));
        }
        return ans.toString();
    }
}