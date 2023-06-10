package leetcode.normal.j1170;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/compare-strings-by-frequency-of-the-smallest-character/">1170. 比较字符串最小字母出现频次</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordAns = new int[words.length];
        for (int i = 0; i < wordAns.length; i++) wordAns[i] = calc(words[i]);
        Arrays.sort(wordAns);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryCnt = calc(queries[i]);
            ans[i] = words.length - binarySearch(wordAns, queryCnt);
        }
        return ans;
    }

    int binarySearch(int[] arr, int target) {
        int ans = arr.length, left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;
    }

    int calc(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) {
            cnt[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return cnt[i];
        }
        return 0;
    }
}