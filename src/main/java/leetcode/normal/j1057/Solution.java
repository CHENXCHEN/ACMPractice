package leetcode.normal.j1057;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/campus-bikes/description/">1057. 校园自行车分配</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class Node {
        public int workIdx, bikeIdx, distance;

        Node(int _wIdx, int _bIdx, int _dis) {
            workIdx = _wIdx;
            bikeIdx = _bIdx;
            distance = _dis;
        }
    }

    int getDistance(int[] dis1, int[] dis2) {
        return Math.abs(dis1[0] - dis2[0]) + Math.abs(dis1[1] - dis2[1]);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(new Node(i, j, getDistance(workers[i], bikes[j])));
            }
        }
        list.sort((a, b) -> {
            if (a.distance != b.distance) return Integer.compare(a.distance, b.distance);
            else if (a.workIdx != b.workIdx) return Integer.compare(a.workIdx, b.workIdx);
            else return Integer.compare(a.bikeIdx, b.bikeIdx);
        });
        boolean[] hasWorker = new boolean[n], hasBike = new boolean[m];
        int[] ans = new int[n];
        for (Node node : list) {
            if (hasWorker[node.workIdx] || hasBike[node.bikeIdx]) {
                continue;
            }
            hasWorker[node.workIdx] = true;
            hasBike[node.bikeIdx] = true;
            ans[node.workIdx] = node.bikeIdx;
        }
        return ans;
    }
}