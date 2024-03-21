package leetcode.normal.j2671;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/frequency-tracker/description/">2671. 频率跟踪器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FrequencyTracker {

    TreeMap<Integer, Integer> cnt, freq;

    public FrequencyTracker() {
        cnt = new TreeMap<>();
        freq = new TreeMap<>();
    }

    int parse(Integer vv) {
        return vv == null ? 0 : vv;
    }

    public void add(int number) {
        Integer afterCnt = cnt.compute(number, (kk, vv) -> parse(vv) + 1);
        if (afterCnt > 0) freq.compute(afterCnt - 1, (kk, vv) -> parse(vv) - 1);
        freq.compute(afterCnt, (kk, vv) -> parse(vv) + 1);
    }

    public void deleteOne(int number) {
        if (cnt.getOrDefault(number, 0) == 0) return;
        Integer afterCnt = cnt.compute(number, (kk, vv) -> parse(vv) - 1);
        freq.compute(afterCnt + 1, (kk, vv) -> parse(vv) - 1);
        freq.compute(afterCnt, (kk, vv) -> parse(vv) + 1);
    }

    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */