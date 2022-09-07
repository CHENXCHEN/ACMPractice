package leetcode.normal.j828;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/">828. 统计子串中的唯一字符</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int uniqueLetterString(String s) {
        int[][] has = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                has[j][i + 1] = has[j][i];
            }
            has[s.charAt(i) - 'A'][i + 1]++;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'A';
            int leftPos = findMinLeft(has[cur], has[cur][i + 1] - 1) + 1 - 1;
            int rightPos = findMaxRight(has[cur], has[cur][i + 1]) - 1;
            int leftCnt = i - leftPos, rightCnt = rightPos - i;
            if (leftPos == -1) leftCnt = 0;
            if (rightPos == -1) rightCnt = 0;
            ans += leftCnt + rightCnt + 1 + leftCnt * rightCnt;
        }
        return ans;
    }

    int findMinLeft(int[] arr, int vv) {
        int left = 0, right = arr.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= vv) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    int findMaxRight(int[] arr, int vv) {
        int left = 0, right = arr.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == vv) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] > vv) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}