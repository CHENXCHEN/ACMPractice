package leetcode.normal.j2182;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/construct-string-with-repeat-limit/description/">2182. 构造限制重复的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append((char) ('a' + i));
                if ((j + 1) % repeatLimit == 0 && j != cnt[i] - 1) {
                    int next = findNext(cnt, i - 1);
                    if (next >= 0) {
                        sb.append((char) ('a' + next));
                        cnt[next]--;
                    } else {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    int findNext(int[] cnt, int pos) {
        for (int i = pos; pos >= 0; pos--) {
            if (cnt[pos] > 0) return pos;
        }
        return -1;
    }
}