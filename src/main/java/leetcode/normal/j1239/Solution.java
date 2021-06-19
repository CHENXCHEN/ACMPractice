package leetcode.normal.j1239;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * 1239. 串联字符串的最大长度
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    ArrayList<String> arr;
    boolean[] validHash;
    int[] arrCompressed;

    public int findMax(int cur, int mark, int len) {
        int ans = len;
        for (int i = cur + 1; i < arrCompressed.length; i++) {
            if (validHash[i] && (mark & arrCompressed[i]) == 0) {
                ans = Math.max(ans, findMax(i, mark | arrCompressed[i], len + arr.get(i).length()));
            }
        }
        return ans;
    }

    public int maxLength(List<String> arr) {
        this.arr = new ArrayList<>(arr);
        validHash = new boolean[this.arr.size()];
        arrCompressed = new int[this.arr.size()];
        for (int i = 0; i < this.arr.size(); i++) {
            String str = this.arr.get(i);
            int ret = 0;
            validHash[i] = true;
            for (int j = 0; j < str.length(); j++) {
                int now = 1 << (str.charAt(j) - 'a');
                if ((ret & now) == 0) {
                    ret |= now;
                } else {
                    validHash[i] = false;
                    break;
                }
            }
            arrCompressed[i] = ret;
        }
        return findMax(-1, 0, 0);
    }
}
