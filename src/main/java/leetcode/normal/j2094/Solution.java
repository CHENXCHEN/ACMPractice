package leetcode.normal.j2094;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/finding-3-digit-even-numbers/description/">2094. 找出 3 位偶数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int digit : digits) {
            cnt[digit]++;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            int[] cnt1 = getCnt(i);
            if (check(cnt, cnt1)) {
                arr.add(i);
            }
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    boolean check(int[] cnt, int[] check) {
        for (int i = 0; i < 10; i++) {
            if (check[i] > cnt[i]) return false;
        }
        return true;
    }

    int[] getCnt(int x) {
        int[] cnt = new int[10];
        while (x > 0) {
            cnt[x % 10]++;
            x /= 10;
        }
        return cnt;
    }
}