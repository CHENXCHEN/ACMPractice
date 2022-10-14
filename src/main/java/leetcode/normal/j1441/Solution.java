package leetcode.normal.j1441;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/build-an-array-with-stack-operations/">1441. 用栈操作构建数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> ans = new ArrayList<>();
        int pos = 0;
        for (int i = 1; i <= n && pos < target.length; i++) {
            ans.add("Push");
            if (target[pos] != i) ans.add("Pop");
            else pos++;
        }
        return ans;
    }
}