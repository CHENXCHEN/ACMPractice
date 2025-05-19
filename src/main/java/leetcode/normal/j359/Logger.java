package leetcode.normal.j359;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/logger-rate-limiter/description/">359. 日志速率限制器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Logger {
    Map<String, Integer> cnt;

    public Logger() {
        cnt = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int last = cnt.getOrDefault(message, -1);
        if (last == -1 || last + 10 <= timestamp) {
            cnt.put(message, timestamp);
            return true;
        } else return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */