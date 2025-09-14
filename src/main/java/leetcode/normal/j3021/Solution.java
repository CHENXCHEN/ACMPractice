package leetcode.normal.j3021;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/alice-and-bob-playing-flower-game/description/">3021. Alice 和 Bob 玩鲜花游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long flowerGame(int n, int m) {
        // 当 x + y 为 奇数时，Alice 获胜，所以求 x 属于 [1,n]，y 属于 [1,m] 的组合数
        // 分类讨论，当 n 分别为奇偶时，m 分别为奇偶的情况
        // x 为奇数，y 为偶数，那么满足 (x,y) 的数目对为 ceil(n / 2) * lower(m / 2)
        // x 为偶数，y 为奇数，那么满足 (x,y) 的数目对为 lower(n / 2) * ceil(m / 2)
        // 两者相加即可，简化后是 m * n / 2
        return (long)m * n / 2;
    }
}
