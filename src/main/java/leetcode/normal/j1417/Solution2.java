package leetcode.normal.j1417;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reformat-the-string/">1417. 重新格式化字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public String reformat(String s) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) num1++;
            else num2++;
        }
        if (Math.abs(num1 - num2) > 1) return "";
        if (num1 > num2) {
            num1 = 0;
            num2 = 1;
        } else {
            num1 = 1;
            num2 = 0;
        }
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                chars[num1] = s.charAt(i);
                num1 += 2;
            } else {
                chars[num2] = s.charAt(i);
                num2 += 2;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ab123 = solution.reformat("a0b1c2");
        System.out.println(ab123);
    }
}
