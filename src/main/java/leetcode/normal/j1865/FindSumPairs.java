package leetcode.normal.j1865;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/finding-pairs-with-a-certain-sum/description/">1865. 找出和为指定值的下标对</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FindSumPairs {
    HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
    int[] nums1, nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i = 0; i < nums1.length; i++) {
            map1.compute(nums1[i], (k, v) -> v == null ? 1 : (v + 1));
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.compute(nums2[i], (k, v) -> v == null ? 1 : (v + 1));
        }
    }

    public void add(int index, int val) {
        int pre = nums2[index];
        nums2[index] += val;
        map2.compute(pre, (k, v) -> v == 1 ? null : (v - 1));
        map2.compute(nums2[index], (k, v) -> v == null ? 1 : (v + 1));
    }

    public int count(int tot) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int cnt = map2.getOrDefault(tot - entry.getKey(), 0);
            ans += entry.getValue() * cnt;
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */