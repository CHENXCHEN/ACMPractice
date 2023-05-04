package leetcode.normal.j2993;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 * 面试题 10.02. 变位词组
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String, ArrayList<String>> tMap = new TreeMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            ArrayList<String> arrayList = tMap.getOrDefault(sorted, new ArrayList<>());
            arrayList.add(str);
            if (arrayList.size() == 1) {
                tMap.put(sorted, arrayList);
                ans.add(arrayList);
            }
        }
        return ans;
    }
}
