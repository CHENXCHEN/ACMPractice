package leetcode.normal.j451;

import java.util.*;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 451. 根据字符出现频率排序
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Byte, Integer> map = new TreeMap<>();
        for (Byte ch : s.getBytes()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        ArrayList<Byte> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (Byte bt : list) {
            Integer cnt = map.get(bt);
            for (int i = 0; i < cnt; i++) {
                sb.append((char) (bt.shortValue()));
            }
        }
        return sb.toString();
    }
}
