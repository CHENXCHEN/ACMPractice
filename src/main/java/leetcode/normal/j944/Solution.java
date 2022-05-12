package leetcode.normal.j944;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * 944. 删列造序
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        boolean[] isDelete = new boolean[strs[0].length()];
        int ans = 0;
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < strs[0].length(); j++) {
                if (!isDelete[j] && strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    isDelete[j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
