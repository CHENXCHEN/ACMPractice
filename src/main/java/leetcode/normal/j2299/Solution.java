package leetcode.normal.j2299;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/strong-password-checker-ii/">2299. 强密码检验器 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        int vis = 0;
        for (int i = 0; i < password.length(); i++) {
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) return false;
            if (Character.isLowerCase(password.charAt(i))) vis |= 1;
            else if (Character.isUpperCase(password.charAt(i))) vis |= 2;
            else if (Character.isDigit(password.charAt(i))) vis |= 4;
            else if ("!@#$%^&*()-+".indexOf(password.charAt(i)) >= 0) vis |= 8;
        }
        return vis == 15;
    }
}