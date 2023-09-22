package leetcode.normal.j2591;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-money-to-maximum-children/description/">2591. 将钱分给最多的儿童</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distMoney(int money, int children) {
        int left = 0, right = children, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(money, mid, children - mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean check(int money, int num, int leafChild) {
        money -= 8 * num;
        if (leafChild == 1 && money == 4) return false;
        if (money > 0 && leafChild == 0) return false;
        return money >= leafChild;
    }
}