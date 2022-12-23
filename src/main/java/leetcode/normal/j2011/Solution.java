package leetcode.normal.j2011;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/">2011. 执行操作后的变量值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String oper : operations) {
            if (oper.charAt(1) == '+') ++ans;
            else --ans;
        }
        return ans;
    }
}