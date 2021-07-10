package leetcode.normal.j981;

import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    TreeMap<String, TreeMap<Integer, String>> mm;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.mm = new TreeMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> version = mm.getOrDefault(key, new TreeMap<Integer, String>());
        version.put(timestamp, value);
        mm.put(key, version);
    }

    public String get(String key, int timestamp) {
        if (!mm.containsKey(key)) return "";
        else {
            TreeMap<Integer, String> version = mm.get(key);
            Map.Entry<Integer, String> ret = version.floorEntry(timestamp + 1);
            if (ret == null) return "";
            else return ret.getValue();
        }
    }
}
