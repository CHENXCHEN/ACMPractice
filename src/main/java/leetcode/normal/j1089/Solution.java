package leetcode.normal.j1089;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/duplicate-zeros/
 * 1089. 复写零
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void duplicateZeros(int[] arr) {
        int[] vis = new int[arr.length];
        int len = 0;
        for (int i = 0; i < arr.length && len < arr.length; i++) {
            vis[len++] = i;
            if (arr[i] == 0 && len < arr.length) vis[len++] = i;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[vis[i]];
        }
    }
}