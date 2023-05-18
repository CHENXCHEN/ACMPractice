package leetcode.normal.j1073;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/adding-two-negabinary-numbers/">1073. 负二进制数相加</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int maxLen = Math.max(len1, len2) + 4;
        int[] ans = new int[maxLen];
        for (int i = 0, pos1 = len1 - 1, pos2 = len2 - 1; i < maxLen - 2; i++, pos1--, pos2--) {
            if (pos1 >= 0) ans[i] += arr1[pos1];
            if (pos2 >= 0) ans[i] += arr2[pos2];
        }
        for (int i = 0; i < maxLen - 2; i++) {
            while (ans[i] > 1) {
                if (ans[i + 1] > 0) {
                    ans[i + 1]--;
                } else {
                    ans[i + 1]++;
                    ans[i + 2]++;
                }
                ans[i] -= 2;
            }
        }
        int i = ans.length - 1;
        while (i > 0 && ans[i] == 0) i--;
        ArrayList<Integer> lst = new ArrayList<>();
        while (i >= 0) lst.add(ans[i--]);
        int[] ret = new int[lst.size()];
        for (int j = 0; j < lst.size(); j++) ret[j] = lst.get(j);
        return ret;
    }
}