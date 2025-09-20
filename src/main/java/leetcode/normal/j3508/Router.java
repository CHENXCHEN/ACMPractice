package leetcode.normal.j3508;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/implement-router/description/">3508. 设计路由器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Router {

    static class Packet {
        int source, dest, ts;

        Packet(int source, int dest, int ts) {
            this.source = source;
            this.dest = dest;
            this.ts = ts;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Packet) {
                Packet p = (Packet) obj;
                return source == p.source && dest == p.dest && ts == p.ts;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result = source;
            result = 31 * result + dest;
            result = 31 * result + ts;
            return result;
        }
    }

    int memoryLimit;
    ArrayDeque<Packet> packetQ = new ArrayDeque<>();
    Set<Packet> packetSet = new HashSet<>();
    Map<Integer, List<Integer>> destToTs = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (packetSet.contains(packet)) {
            return false;
        }
        packetQ.add(packet);
        packetSet.add(packet);
        destToTs.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        if (packetQ.size() > memoryLimit) {
            forwardPacket();
        }
        return true;
    }

    public int[] forwardPacket() {
        if (packetQ.isEmpty()) return new int[0];
        Packet packet = packetQ.poll();
        packetSet.remove(packet);
        destToTs.get(packet.dest).remove(0);
        return new int[]{packet.source, packet.dest, packet.ts};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> tsArr = destToTs.computeIfAbsent(destination, k -> new ArrayList<>());
//        System.out.println("destination: " + destination + ", start: " + startTime + ", end: " + endTime);
//        System.out.println("ts: " + Arrays.toString(tsArr.toArray()));
        int leftIdx = binarySearch(tsArr, startTime);
        int rightIdx = binarySearch(tsArr, endTime + 1);
//        System.out.println("leftIdx: " + leftIdx + ", rightIdx: " + rightIdx);
        return rightIdx - leftIdx;
    }

    int binarySearch(List<Integer> tsArr, int target) {
        // 找到 >= target 的最小位置
        int left = 0, right = tsArr.size() - 1, ans = tsArr.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tsArr.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */