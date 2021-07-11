package leetcode.normal.j274;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/h-index/
 * 274. H 指数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int hIndex(int[] citations) {
//        List<Integer> sorted = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder())
//                .collect(Collectors.toList());
//        int index = 1;
//        int ans = 0;
//        for (Integer elem : sorted) {
//            if (elem >= index) {
//                ans = index;
//            }
//            ++index;
//        }
//        return ans;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
