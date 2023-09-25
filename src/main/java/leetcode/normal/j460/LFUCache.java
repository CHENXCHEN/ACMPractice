package leetcode.normal.j460;

import javafx.util.Pair;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lfu-cache/description/">460. LFU 缓存</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class LFUCache {
    int capacity, ts;

    TreeMap<Integer, Integer> data;
    TreeMap<Pair<Integer, Integer>, Integer> recordToNum;
    TreeMap<Integer, Pair<Integer, Integer>> numToRecord;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        ts = 0;
        data = new TreeMap<>();
        recordToNum = new TreeMap<>((a, b) -> !a.getKey().equals(b.getKey()) ? Integer.compare(a.getKey(), b.getKey()) : Integer.compare(a.getValue(), b.getValue()));
        numToRecord = new TreeMap<>();
    }

    public int get(int key) {
        Integer vv = data.get(key);
        if (vv == null) {
            return -1;
        }
        updateAccess(key);
        return vv;
    }

    public void put(int key, int value) {
        if (!data.containsKey(key) && data.size() >= capacity) {
            Map.Entry<Pair<Integer, Integer>, Integer> needRemove = recordToNum.firstEntry();
            recordToNum.remove(needRemove.getKey());
            numToRecord.remove(needRemove.getValue());
            data.remove(needRemove.getValue());
        }
        data.put(key, value);
        updateAccess(key);
    }

    void updateAccess(int key) {
        ++ts;
        Pair<Integer, Integer> record = numToRecord.get(key);
        if (record == null) record = new Pair<>(0, ts);
        Pair<Integer, Integer> newRecord = new Pair<>(record.getKey() + 1, ts);
        recordToNum.remove(record);
        recordToNum.put(newRecord, key);
        numToRecord.put(key, newRecord);
    }
}