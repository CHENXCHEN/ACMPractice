package leetcode.normal.j706;

import java.util.LinkedList;

class MyHashMap {
    int mod = (int) 1e5;
    LinkedList<int[]>[] list;

    public MyHashMap() {
        list = new LinkedList[mod];
    }

    public void put(int key, int value) {
        int sign = key % mod;
        if (list[sign] == null) list[sign] = new LinkedList<>();
        boolean check = false;
        for (int[] arr : list[sign]) {
            if (arr[0] == key) {
                arr[1] = value;
                check = true;
                break;
            }
        }
        if (!check) {
            list[sign].add(new int[]{key, value});
        }
    }

    public int get(int key) {
        int sign = key % mod;
        if (list[sign] == null) return -1;
        for (int[] arr : list[sign]) {
            if (arr[0] == key) return arr[1];
        }
        return -1;
    }

    public void remove(int key) {
        int sign = key % mod;
        if (list[sign] != null) {
            list[sign].removeIf(x -> x[0] == key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */