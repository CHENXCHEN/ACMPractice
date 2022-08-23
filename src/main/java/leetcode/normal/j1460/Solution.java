package leetcode.normal.j1460;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/">1460. 通过翻转子数组使两个数组相等</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        int[] vis = new int[1001];
        for (int i = 0; i < target.length; i++) {
            ++vis[target[i]];
            --vis[arr[i]];
        }
        for (int i = 1; i <= 1000; i++) {
            if (vis[i] != 0) return false;
        }
        return true;
    }
}