package leetcode.normal.j593;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/valid-square/">593. 有效的正方形</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2) || Arrays.equals(p3, p4) || Arrays.equals(p2, p3) || Arrays.equals(p1, p4))
            return false;
        return help(p1, p2, p3, p4) ||
                help(p1, p3, p2, p4) ||
                help(p1, p4, p2, p3);
    }

    // p1->p2, p3->p4 是对边
    boolean help(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] v1 = {p1[0] - p2[0], p1[1] - p2[1]};
        int[] v2 = {p3[0] - p4[0], p3[1] - p4[1]};
        int[] v3;
        if (checkDirect(v1, v2)) {
            // 如果方向相同
            v3 = new int[]{p1[0] - p3[0], p1[1] - p3[1]};
        } else {
            // 如果方向不同
            v3 = new int[]{p1[0] - p4[0], p1[1] - p4[1]};
        }
        boolean isPara = checkPara(v1, v2);
        boolean checkLength = checkLength(v1, v2) && checkLength(v1, v3);
        boolean calcCos = calcCos(v1, v3);
        return isPara && checkLength && calcCos;
    }

    // 判断两边是否平行
    boolean checkPara(int[] v1, int[] v2) {
        return v1[0] * v2[1] - v2[0] * v1[1] == 0;
    }

    // 判断两边是否相等
    boolean checkLength(int[] v1, int[] v2) {
        return v1[0] * v1[0] + v1[1] * v1[1] == v2[0] * v2[0] + v2[1] * v2[1];
    }

    // 判断两条边角度是否为正交
    boolean calcCos(int[] v1, int[] v2) {
        return (v1[0] * v2[0] + v1[1] * v2[1]) == 0;
    }

    // 判断两个向量是否同向
    boolean checkDirect(int[] v1, int[] v2) {
        return v1[0] == v2[0] && v1[1] == v2[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.validSquare(new int[]{0, 0}, new int[]{5, 0}, new int[]{5, 4}, new int[]{0, 4})
        );
    }
}