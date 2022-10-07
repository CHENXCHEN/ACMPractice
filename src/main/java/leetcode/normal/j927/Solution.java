package leetcode.normal.j927;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/three-equal-parts/">927. 三等分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int oneCnt = 0;
        for (int num : arr) oneCnt += num;
        int[] ans = new int[]{-1, -1};
        if (oneCnt % 3 != 0) return ans;
        if (oneCnt == 0) {
            ans[0] = 0;
            ans[1] = 2;
            return ans;
        }
        int partCnt = oneCnt / 3;
        int[] pos = new int[]{-1, -1, -1};
        int[] cnt = new int[]{0, 0, 0};
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (pos[cur] == -1) pos[cur] = i;
                cnt[cur]++;
                if (cnt[cur] == partCnt) ++cur;
            }
        }
        while (pos[2] < arr.length) {
            if (!check(pos, cnt, arr)) return ans;
        }
        ans[0] = pos[0] - 1;
        if (ans[0] < 0) ans[0] = 0;
        ans[1] = pos[1];
        return ans;
    }

    boolean check(int[] pos, int[] cnt, int[] arr) {
        int cmp = arr[pos[0]];
        for (int i = 0; i < 3; i++) {
            if (arr[pos[i]] != cmp) return false;
            cnt[i] -= arr[pos[i]];
            if (cnt[i] < 0) return false;
            pos[i]++;
        }
        return true;
    }
}