package leetcode.normal.j165;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * 165. 比较版本号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> versions1 = Arrays.stream(version1.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> versions2 = Arrays.stream(version2.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
        int maxLen = Math.max(version1.length(), version2.length());
        versions1.addAll(Collections.nCopies(maxLen - versions1.size(), 0));
        versions2.addAll(Collections.nCopies(maxLen - versions2.size(), 0));
        for (int i = 0; i < maxLen; i++) {
            if (versions1.get(i) > versions2.get(i)) return 1;
            else if (versions1.get(i) < versions2.get(i)) return -1;
        }
        return 0;
    }
}