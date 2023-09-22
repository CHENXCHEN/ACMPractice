package leetcode.normal.j2591;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distribute-money-to-maximum-children/description/">2591. 将钱分给最多的儿童</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        // 首先每个孩子至少分配 1 美元
        money -= children;
        // 接着尽可能分配 7 美元给这些孩子
        int cnt = Math.min(money / 7, children);
        children -= cnt;
        money -= cnt * 7;
        // 如果剩下一个是 4 美元或者没有孩子还剩下钱
        if ((children == 1 && money == 3) || (children == 0 && money > 0)) --cnt;
        return cnt;
    }
}
