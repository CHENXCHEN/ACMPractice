package leetcode.normal.j1054;

import javafx.util.Pair;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distant-barcodes/">1054. 距离相等的条形码</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> y.getKey() - x.getKey());
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int barcode : barcodes) {
            tMap.put(barcode, tMap.getOrDefault(barcode, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
            pq.add(new Pair<>(entry.getValue(), entry.getKey()));
        }
        int[] ans = new int[barcodes.length];
        int tot = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> cur = pq.poll();
            if (tot > 0 && ans[tot - 1] == cur.getValue()) {
                Pair<Integer, Integer> next = pq.poll();
                if (next != null) {
                    pq.add(cur);
                    cur = next;
                }
            }
            ans[tot++] = cur.getValue();
            if (cur.getKey() - 1 > 0)
                pq.add(new Pair<>(cur.getKey() - 1, cur.getValue()));
        }
        return ans;
    }
}