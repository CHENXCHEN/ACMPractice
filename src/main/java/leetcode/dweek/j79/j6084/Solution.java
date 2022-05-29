package leetcode.dweek.j79.j6084;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/sender-with-largest-word-count/
 * 6084. 最多单词数的发件人
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        TreeMap<String, Integer> tMap = new TreeMap<>();
        for (String sender : senders) tMap.putIfAbsent(sender, tMap.size());
        int[] has = new int[tMap.keySet().size()];
        int ans = 0;
        String maxSender = "";
        for (int i = 0; i < messages.length; i++) {
            int wordsCnt = messages[i].split(" ").length;
            int numSender = tMap.get(senders[i]);
            has[numSender] += wordsCnt;
            if (has[numSender] > ans || (has[numSender] == ans && senders[i].compareTo(maxSender) > 0)) {
                ans = has[numSender];
                maxSender = senders[i];
            }
        }
        return maxSender;
    }
}