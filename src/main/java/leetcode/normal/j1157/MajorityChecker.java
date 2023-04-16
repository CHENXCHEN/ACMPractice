package leetcode.normal.j1157;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/online-majority-element-in-subarray/">1157. 子数组中占绝大多数的元素</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MajorityChecker {
    TreeMap<Integer, ArrayList<Integer>> tMap;
    Random random;
    int[] arr;

    public MajorityChecker(int[] arr) {
        tMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            tMap.putIfAbsent(arr[i], new ArrayList<>());
            tMap.get(arr[i]).add(i);
        }
        random = new Random();
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int len = right - left + 1;
        for (int k = 0; k < 20; k++) {
            // 先在 [left,right] 中随机找一个数，如果符合就返回，如果不符合但是绝对众数，那一定不存在
            // 每次随机找一个，有 1/2 的概率找到这个数，找 20 次，概率就已经到了 99%
            int x = arr[left + random.nextInt(len)];
            ArrayList<Integer> pos = tMap.get(x);
            int occ = binarySearch(pos, right) - binarySearch(pos, left - 1);
            if (occ >= threshold) return x;
            else if ((occ << 1) >= len) return -1;
        }
        return -1;
    }

    int binarySearch(ArrayList<Integer> pos, int target) {
        if (target < pos.get(0)) return -1;
        int left = 0, right = pos.size() - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (pos.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */