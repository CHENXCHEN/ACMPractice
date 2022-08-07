package leetcode.normal.j636;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/exclusive-time-of-functions/">636. 函数的独占时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class FuncNode {
        int idx, ts, op;

        FuncNode(int _idx, int _ts, int _op) {
            idx = _idx;
            ts = _ts;
            op = _op;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int lastTs = 0;
        ArrayDeque<FuncNode> deque = new ArrayDeque<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int idx = Integer.parseInt(split[0]);
            int ts = Integer.parseInt(split[2]);
            FuncNode funcNode = new FuncNode(idx, ts, split[1].equals("end") ? 1 : 0);
            if (deque.isEmpty()) {
                deque.push(funcNode);
                lastTs = funcNode.ts;
            } else {
                if (funcNode.op == 1) {
                    ans[funcNode.idx] += funcNode.ts - lastTs + 1;
                    lastTs = funcNode.ts + 1;
                    deque.pop();
                } else {
                    ans[deque.peek().idx] += funcNode.ts - lastTs;
                    lastTs = funcNode.ts;
                    deque.push(funcNode);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14", "7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40", "3:end:45", "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69", "2:end:70", "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85", "1:start:89", "1:end:93", "2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114"};
        List<String> collect = Arrays.stream(strs).collect(Collectors.toList());
        Solution solution = new Solution();
        solution.exclusiveTime(8, collect);
    }
}