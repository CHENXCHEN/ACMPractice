package leetcode.normal.j1262;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/greatest-sum-divisible-by-three/">1262. 可被三整除的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int maxSumDivThree(int[] nums) {
        // 获取每个元素对 3 取模的结果列表，num % 3 只有 3 种情况，0 / 1 / 2
        // 这三种情况中，0 的元素我们可以全部都取，而 1 / 2 的元素，我们可以贪心取
        // 我们可以取 cnt1 为取模为 1 的个数，cnt2 为取模为 2 的个数
        // 那么可以得到公式 (cnt1 + 2 * cnt2) % 3 = (cnt1 - cnt2) % 3
        // 答案一定是在答案一定在 [cnt1 - 2, cnt1] 和 [cnt2 - 2, cnt2]
        // 因为如果是 cnt1 - 3 的话，我们在 1 中再取 3 个数，不会改变同余的结果
        ArrayList<Integer>[] res = new ArrayList[3];
        for (int i = 0; i < res.length; i++) res[i] = new ArrayList<>();
        for (int num : nums) res[num % 3].add(num);
        for (ArrayList<Integer> re : res) re.sort((x, y) -> y - x);
        int ans = 0;
        for (int cnt1 = res[1].size() - 2; cnt1 <= res[1].size(); cnt1++) {
            if (cnt1 >= 0) {
                for (int cnt2 = res[2].size() - 2; cnt2 <= res[2].size(); cnt2++) {
                    if (cnt2 >= 0 && (cnt1 - cnt2) % 3 == 0) {
                        ans = Math.max(ans, getSum(res[1], cnt1) + getSum(res[2], cnt2));
                    }
                }
            }
        }
        return getSum(res[0], res[0].size()) + ans;
    }

    int getSum(ArrayList<Integer> list, int len) {
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += list.get(i);
        }
        return ans;
    }
}
