package leetcode.normal.j1436;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/destination-city/description/">1436. 旅行终点站</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> vis = new HashSet<>();
        for (List<String> path : paths) {
            vis.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!vis.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}