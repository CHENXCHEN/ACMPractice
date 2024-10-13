package leetcode.normal.j1884;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/description/">1884. 鸡蛋掉落-两枚鸡蛋</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int twoEggDrop(int n) {
        // 假设答案为 T，即最小需要 T 次操作
        // 第一次在 T 层尝试，如果失败，那么依次尝试 [1,T)，有 T-1 次
        // 第二次在 T + (T - 1) 层尝试，如果失败，那么依次尝试 [T+1,T+(T-1)，有 T-2 次
        // 第三次在 T + (T - 1) + (T - 2) 层尝试，如果失败，那么依次尝试 [T+(T-1),T+(T-1)+(T-2)，有 T-3 次
        // T 次操作最多可以确定的楼层数为 T + (T - 1) + (T - 2) + ... + 1 = T(T+1)/2
        // 找到最小的正整数T，使得 T(T+1)/2 >= n，则为答案
        // 转换为 T >= (-1 + sqrt(1+8n))/2
        return (int) Math.ceil((-1 + Math.sqrt(1 + 8 * n)) / 2);
    }
}