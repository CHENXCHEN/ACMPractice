package leetcode.normal.j1055;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-way-to-form-string/description/">1055. 形成字符串的最短路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int shortestWay(String source, String target) {
        ArrayList<Integer>[] chPos = new ArrayList[26];
        for (int i = 0; i < 26; i++) chPos[i] = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            chPos[source.charAt(i) - 'a'].add(i);
        }
        int last = -1, ans = 1;
        for (int i = 0; i < target.length(); i++) {
            int cur = target.charAt(i) - 'a';
            ArrayList<Integer> curPos = chPos[cur];
            if (curPos.isEmpty()) return -1;
            int nextPos = binarySearch(curPos, last);
            if (nextPos == -1) {
                ans++;
                last = curPos.get(0);
            } else {
                last = nextPos;
            }
        }
        return ans;
    }

    int binarySearch(ArrayList<Integer> arr, int start) {
        int left = 0, right = arr.size() - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr.get(mid) > start) {
                ans = arr.get(mid);
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }
}