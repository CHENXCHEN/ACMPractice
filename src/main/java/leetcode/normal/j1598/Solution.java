package leetcode.normal.j1598;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/crawler-log-folder/">1598. 文件夹操作日志搜集器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (!log.equals("./")) {
                if (log.equals("../")) {
                    if (ans != 0) --ans;
                } else ans++;
            }
        }
        return ans;
    }
}