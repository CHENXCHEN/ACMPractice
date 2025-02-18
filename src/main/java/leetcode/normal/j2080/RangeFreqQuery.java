package leetcode.normal.j2080;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/range-frequency-queries/description/">2080. 区间内查询数字的频率</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class RangeFreqQuery {

    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.compute(arr[i], (k, v) -> v == null ? new ArrayList<>() : v).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        int leftPos = searchGreaterOrEqual(list, left);
        int rightPos = searchLessOrEqual(list, right);
        if (leftPos == -1 || rightPos == -1) return 0;
        return rightPos - leftPos + 1;
    }

    int searchGreaterOrEqual(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    int searchLessOrEqual(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */