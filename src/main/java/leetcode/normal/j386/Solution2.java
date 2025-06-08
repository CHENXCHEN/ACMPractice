package leetcode.normal.j386;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographical-numbers/description/">386. 字典序排数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int number = 1;
        for (int i = 1; i <= n; i++) {
            ans.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ans;
    }
}