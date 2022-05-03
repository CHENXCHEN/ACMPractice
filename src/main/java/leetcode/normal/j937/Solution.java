package leetcode.normal.j937;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * 937. 重新排列日志文件
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    Boolean isAlphaLog(String str) {
        String[] s = str.split(" ");
        for (int i = 1; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                if (!Character.isLowerCase(s[i].charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Pair {
        String key, value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        TreeMap<Pair, Integer> tMap = new TreeMap<>(Comparator.comparing(Pair::getKey).thenComparing(Pair::getValue));
        ArrayList<String> numberLogs = new ArrayList<>(), ans = new ArrayList<>();
        for (String log : logs) {
            if (isAlphaLog(log)) {
                int firstSpace = log.indexOf(' ');
                String vLog = log.substring(firstSpace + 1);
                String vSign = log.substring(0, firstSpace);
                Pair pair = new Pair(vLog, vSign);
                tMap.put(pair, tMap.getOrDefault(pair, 0) + 1);
            } else {
                numberLogs.add(log);
            }
        }
        tMap.forEach((encodeKey, repeat) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(encodeKey.getValue()).append(' ').append(encodeKey.getKey());
            for (int i = 0; i < repeat; i++) {
                ans.add(sb.toString());
            }
        });
        ans.addAll(numberLogs);
        String[] arr = new String[ans.size()];
        arr = ans.toArray(arr);
        return arr;
    }
}
