package leetcode.normal.j690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/employee-importance/description/">690. 员工的重要性</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Map<Integer, List<Integer>> edges;
    Map<Integer, Integer> nodeV;

    public int getImportance(List<Employee> employees, int id) {
        edges = new HashMap<>();
        nodeV = new HashMap<>();
        for (Employee employee : employees) {
            nodeV.put(employee.id, employee.importance);
            edges.computeIfAbsent(employee.id, x -> new ArrayList<>()).addAll(employee.subordinates);
        }
        return getV(id);
    }

    int getV(int id) {
        int ans = nodeV.get(id);
        for (Integer to : edges.get(id)) {
            ans += getV(to);
        }
        return ans;
    }
}