package leetcode.normal.j1616;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-two-strings-to-make-palindrome/">1616. 分割两个字符串得到回文串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    boolean check(String a, String b) {
        int start = 0, end = a.length() - 1;
        while (start < end && a.charAt(start) == b.charAt(end)) {
            ++start;
            --end;
        }
        if (start >= end) return true;
        return checkSelf(a, start, end) || checkSelf(b, start, end);
    }

    boolean checkSelf(String a, int start, int end) {
        while (start < end && a.charAt(start) == a.charAt(end)) {
            ++start;
            --end;
        }
        return start >= end;
    }
}