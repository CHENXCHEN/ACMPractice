package leetcode.normal.j2081;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-k-mirror-numbers/description/">2081. k 镜像数字的和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] digit = new int[100];

    public long kMirror(int k, int n) {
        long ans = 0;
        int left = 1, count = 0;
        while (count < n) {
            int right = left * 10;
            // op = 0 表示枚举奇数长度，op = 1 表示枚举偶数长度
            for (int op = 0; op < 2; op++) {
                for (int i = left; i < right && count < n; i++) {
                    long combine = i;
                    int x = (op == 0 ? i / 10 : i);
                    while (x > 0) {
                        combine = combine * 10 + x % 10;
                        x /= 10;
                    }
                    if (isPalidrome(combine, k)) {
                        ++count;
                        ans += combine;
                    }
                }
            }
            left = right;
        }
        return ans;
    }

    boolean isPalidrome(long x, int k) {
        int length = -1;
        while (x > 0) {
            ++length;
            digit[length] = (int) (x % k);
            x /= k;
        }
        for (int i = 0, j = length; i < j; i++, j--) {
            if (digit[i] != digit[j]) return false;
        }
        return true;
    }
}