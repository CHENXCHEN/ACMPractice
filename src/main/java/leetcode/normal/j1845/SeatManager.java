package leetcode.normal.j1845;

import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/seat-reservation-manager/description/">1845. 座位预约管理系统</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class SeatManager {

    TreeSet<Integer> tSet;
    int n;

    public SeatManager(int n) {
        this.n = n;
        tSet = new TreeSet<>();
        for (int i = 1; i <= n; i++) tSet.add(i);
    }

    public int reserve() {
        return tSet.pollFirst();
    }

    public void unreserve(int seatNumber) {
        tSet.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */