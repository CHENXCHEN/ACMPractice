package leetcode.normal.j752;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/open-the-lock/submissions/
 * 752. 打开转盘锁
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    String addOnePosition(String s, int pos, int vv) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int num = (sb.charAt(pos) - '0' + vv + 10) % 10;
        sb.setCharAt(pos, (char) ('0' + num));
        return sb.toString();
    }

    Optional<String> walk(Set<String> deadEndSet, Map<String, Integer> tMap, String next, Integer step) {
        if (!deadEndSet.contains(next)) {
            if (!tMap.containsKey(next) || tMap.get(next) > step + 1) {
                tMap.put(next, step + 1);
                return Optional.of(next);
            }
        }
        return Optional.empty();
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = Arrays.stream(deadends).collect(Collectors.toSet());
        if (deadEndSet.contains("0000")) return -1;
        Map<String, Integer> tMap = new TreeMap<>();
        tMap.put("0000", 0);
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        while (!q.isEmpty()) {
            String cur = q.poll();
            Integer step = tMap.get(cur);
            if (cur == target) return step;
            for (int i = 0; i < 4; i++) {
                walk(deadEndSet, tMap, addOnePosition(cur, i, 1), step).ifPresent(q::add);
                walk(deadEndSet, tMap, addOnePosition(cur, i, -1), step).ifPresent(q::add);
            }
        }
        return tMap.getOrDefault(target, -1);
    }
}