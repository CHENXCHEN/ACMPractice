package leetcode.normal.j65;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/valid-number/
 * 65. 有效数字
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isAllDigit(String s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(String s, int start, int end, boolean canEmpty, boolean canWithPrefix) {
        boolean isPrefix = start < end && (s.charAt(start) == '+' || s.charAt(start) == '-');
        if (canEmpty && canWithPrefix) {
            if (isPrefix) return end - start > 1 && isAllDigit(s, start + 1, end);
            else return isAllDigit(s, start, end);
        } else if (canEmpty && !canWithPrefix) {
            if (isPrefix) return false;
            else return isAllDigit(s, start, end);
        } else if (!canEmpty && canWithPrefix) {
            if (isPrefix) return end - start > 1 && isAllDigit(s, start + 1, end);
            else return start < end && isAllDigit(s, start, end);
        } else {
            if (isPrefix) return false;
            else return start < end && isAllDigit(s, start, end);
        }
    }

    public boolean isFloatNumber(String s, int start, int end) {
        if (start == end) return false;
        boolean isPrefix = start < end && (s.charAt(start) == '+' || s.charAt(start) == '-');
        int dotPos = s.indexOf('.');
        if (dotPos == -1) return isNumber(s, start, end, false, true);
        else {
            if (isPrefix) start += 1;
            if (start == dotPos) return isNumber(s, start + 1, end, false, false);
            else return isNumber(s, start, dotPos, false, false) && isNumber(s, dotPos + 1, end, true, false);
        }
    }

    public boolean isNumber(String s) {
        int ePos = s.indexOf('e');
        if (ePos == -1) ePos = s.indexOf('E');
        if (ePos != -1) return isFloatNumber(s, 0, ePos) && isNumber(s, ePos + 1, s.length(), false, true);
        else return isFloatNumber(s, 0, s.length());
    }
}