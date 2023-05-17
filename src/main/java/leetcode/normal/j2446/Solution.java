package leetcode.normal.j2446;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict/">2446. 判断两个事件是否存在冲突</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        return between(event1[0], event1[1], event2[0]) ||
                between(event1[0], event1[1], event2[1]) ||
                between(event2[0], event2[1], event1[0]) ||
                between(event2[0], event2[1], event1[1]);
    }

    boolean between(String start, String end, String cmp) {
        return start.compareTo(cmp) <= 0 && cmp.compareTo(end) <= 0;
    }
}