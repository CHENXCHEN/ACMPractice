package leetcode.normal.j146;

import javafx.util.Pair;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lru-cache/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=fuhc5v1">146. LRU 缓存</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class LRUCache {
    int capacity, tot;
    TreeMap<Integer, Integer> tsMap = new TreeMap<>();
    TreeMap<Integer, Pair<Integer, Integer>> kvMap = new TreeMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tot = 0;
    }

    public int get(int key) {
        if (kvMap.containsKey(key)) {
            updateKeyTs(key);
            return kvMap.get(key).getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            addKey(key, value);
        } else {
            if (kvMap.size() >= capacity) {
                removeMin();
            }
            addKey(key, value);
        }
    }

    void updateKeyTs(int key) {
        Pair<Integer, Integer> entry = kvMap.get(key);
        tsMap.remove(entry.getKey());
        tsMap.put(++tot, key);
        kvMap.put(key, new Pair<>(tot, entry.getValue()));
    }

    void addKey(int key, int val) {
        Pair<Integer, Integer> entry = kvMap.get(key);
        if (entry != null) {
            tsMap.remove(entry.getKey());
        }
        tsMap.put(++tot, key);
        kvMap.put(key, new Pair<>(tot, val));
    }

    void removeMin() {
        Map.Entry<Integer, Integer> entry = tsMap.firstEntry();
        tsMap.remove(entry.getKey());
        kvMap.remove(entry.getValue());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */