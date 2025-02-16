package leetcode.normal.j1299;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/description/">1299. 将每个元素替换为右侧最大元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = -1;
        int last = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            ans[i] = last;
            last = Math.max(last, arr[i]);
        }
        return ans;
    }
}