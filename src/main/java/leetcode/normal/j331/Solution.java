package leetcode.normal.j331;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/description/">331. 验证二叉树的前序序列化</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int idx;
    String[] orderLst;

    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 1) return preorder.charAt(0) == '#';
        orderLst = preorder.split(",");
        System.out.println(Arrays.toString(orderLst));
        idx = 0;
        boolean check = check("#");
        return check && idx >= orderLst.length;
    }

    boolean check(String parent) {
        if (idx >= orderLst.length) return false;
        String cur = orderLst[idx++];
        if (cur.equals("#")) return !parent.equals("#");
        return check(cur) && check(cur);
    }
}