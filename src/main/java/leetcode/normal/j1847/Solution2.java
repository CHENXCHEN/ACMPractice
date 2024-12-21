package leetcode.normal.j1847;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/closest-room/description/">1847. 最近的房间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    int[][] rmq;

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        // 要求找到距离某个 roomId 最近的至少 >= minSize 的房间 id，如果有相同，则取最小 roomId
        // 本题的关键在于查询的 roomId，面积只要大于最小值即可
        // 若我们先固定其中一个维度，比如对 roomId 做排序，再依次从 roomId 的周围找满足 size 的最近坐标
        // 我们可以使用 rmq 来做区间的最值范围查询
        Arrays.sort(rooms, (x, y) -> x[0] - y[0]);
        int n = rooms.length, k = 31 - Integer.numberOfLeadingZeros(n);
        // rmq[i][j] 表示 [i,i+2^j - 1] 的最大值
        rmq = new int[n][k + 1];
        for (int j = 0; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                if (j == 0) rmq[i][j] = rooms[i][1];
                else {
                    int childLen = 1 << (j - 1);
                    int leftMax = rmq[i][j - 1];
                    int rightMax = i + childLen < n ? rmq[i + childLen][j - 1] : Integer.MIN_VALUE;
                    rmq[i][j] = Math.max(leftMax, rightMax);
                }
            }
        }
        TreeMap<Integer, Integer> roomIds = new TreeMap<>();
        for (int i = 0; i < n; i++) roomIds.put(rooms[i][0], i);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            int roomId = queries[i][0], size = queries[i][1];
            Map.Entry<Integer, Integer> higherRoomEntry = roomIds.ceilingEntry(roomId);
            Map.Entry<Integer, Integer> lowerRoomEntry = roomIds.floorEntry(roomId);
            int rightRoomIdx = -1, leftRoomIdx = -1;
            if (higherRoomEntry != null) rightRoomIdx = queryRight(higherRoomEntry.getValue(), size);
            if (lowerRoomEntry != null) leftRoomIdx = queryLeft(lowerRoomEntry.getValue(), size);
            int dis = Integer.MAX_VALUE;
            if (leftRoomIdx != -1) {
                ans[i] = rooms[leftRoomIdx][0];
                dis = roomId - rooms[leftRoomIdx][0];
            }
            if (rightRoomIdx != -1 && rooms[rightRoomIdx][0] - roomId < dis) {
                ans[i] = rooms[rightRoomIdx][0];
            }
        }
        return ans;
    }

    int queryRight(int start, int target) {
        int left = start, right = rmq.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getRangeMax(start, mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    int queryLeft(int end, int target) {
        int left = 0, right = end, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getRangeMax(mid, end) >= target) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    int getRangeMax(int left, int right) {
        int len = right - left + 1, k = 31 - Integer.numberOfLeadingZeros(len);
        if (k == 0) return rmq[left][k];
//        System.out.println("len: " + len + " k: " + k + " left: " + left + " right: " + right);
        return Math.max(rmq[left][k], rmq[right - (1 << k) + 1][k]);
    }
}