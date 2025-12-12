package leetcode.normal.j3433;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-mentions-per-user/description/">3433. 统计用户被提及情况</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        int allMetionCnt = 0;
        // 用户 x 在 y 时间点上线，如果不存在则表示在线上
        int[] activeUsers = new int[numberOfUsers+1];
        events.sort((x, y) ->
                Integer.parseInt(x.get(1)) != Integer.parseInt(y.get(1)) ?
                        (Integer.parseInt(x.get(1)) - Integer.parseInt(y.get(1))) : (int)(y.get(0).charAt(0) - x.get(0).charAt(0)));
        for (List<String> event : events) {
            String op = event.get(0);
            int ts = Integer.parseInt(event.get(1));
            String ids = event.get(2);
            if (op.equals("MESSAGE")) {
                if (ids.equals("ALL")) ++allMetionCnt;
                else if (ids.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; ++i) {
                        if (activeUsers[i] <= ts) {
                            ans[i]++;
                        }
                    }
                } else {
                    String[] items = ids.split(" ");
                    for (String item : items) {
                        int idx = Integer.parseInt(item.substring(2));
                        ans[idx]++;
                    }
                }
            } else {
                int idx = Integer.parseInt(ids);
                activeUsers[idx] = ts + 60;
            }
        }
        for (int i = 0; i < numberOfUsers; ++i) {
            ans[i] += allMetionCnt;
        }
        return ans;
    }
}