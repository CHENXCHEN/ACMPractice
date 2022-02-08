package leetcode.normal.j1405;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/longest-happy-string/
 * 1405. 最长快乐字符串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class Node {
        int cnt;
        char ch;

        Node(int _cnt, char _ch) {
            cnt = _cnt;
            ch = _ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        Node[] arr = new Node[3];
        arr[0] = new Node(a, 'a');
        arr[1] = new Node(b, 'b');
        arr[2] = new Node(c, 'c');
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean hasNext = false;
            Arrays.sort(arr, (from, next) -> next.cnt - from.cnt);
            int len = sb.length();
            for (int i = 0; i < 3; i++) {
                Node node = arr[i];
                if (node.cnt > 0 && !(len >= 2 && sb.charAt(len - 2) == node.ch && sb.charAt(len - 1) == node.ch)) {
                    node.cnt--;
                    sb.append(node.ch);
                    hasNext = true;
                    break;
                }
            }
            if (!hasNext) break;
        }
        return sb.toString();
    }
}