package leetcode.normal.j3208;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/alternating-groups-ii/">3208. 交替组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] colors;
    int n;

    public int numberOfAlternatingGroups(int[] colors, int k) {
        n = colors.length;
        this.colors = colors;
        boolean[] visit = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i] && isValid(i)) {
                visit[i] = true;
                int left = (i - 1 + n) % n, right = (i + 1) % n;
                int cnt = 1;
                while (left != i && isValid(left) && !visit[left]) {
                    ++cnt;
                    visit[left] = true;
                    left = (left - 1 + n) % n;
                }
                while (right != i && isValid(right) && !visit[right]) {
                    ++cnt;
                    visit[right] = true;
                    right = (right + 1) % n;
                }
                if (cnt == n) ans += n;
                else if (cnt + 2 >= k) ans += cnt + 2 - k + 1;
            }
        }
        return ans;
    }

    boolean isValid(int pos) {
        int pre = (pos - 1 + n) % n, next = (pos + 1) % n;
        return colors[pos] != colors[next] && colors[pos] != colors[pre];
    }

}