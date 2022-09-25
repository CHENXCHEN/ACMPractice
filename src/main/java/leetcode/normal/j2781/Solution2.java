package leetcode.normal.j2781;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/missing-two-lcci/">面试题 17.19. 消失的两个数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int xor = (n + 1) ^ (n + 2);
        for (int i = 0; i < n; i++) {
            xor ^= (i + 1) ^ nums[i];
        }
        int lsb = xor & -xor;
        int type1 = 0, type2 = 0;
        if (((n + 1) & lsb) == 0) type1 ^= n + 1;
        else type2 ^= n + 1;
        if (((n + 2) & lsb) == 0) type1 ^= n + 2;
        else type2 ^= n + 2;

        for (int i = 0; i < n; i++) {
            if (((i + 1) & lsb) == 0) type1 ^= i + 1;
            else type2 ^= i + 1;
            if ((nums[i] & lsb) == 0) type1 ^= nums[i];
            else type2 ^= nums[i];
        }
        return new int[]{type1, type2};
    }
}