package leetcode.normal.j705;

import java.util.LinkedList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-hashset/description/">705. 设计哈希集合</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyHashSet {
    int mod = (int) 1e5;
    LinkedList<Integer>[] list;

    public MyHashSet() {
        list = new LinkedList[mod];
    }

    public void add(int key) {
        int sign = key % mod;
        if (list[sign] == null) list[sign] = new LinkedList<>();
        if (list[sign].stream().noneMatch(x -> x == key))
            list[sign].add(key);
    }

    public void remove(int key) {
        int sign = key % mod;
        LinkedList<Integer> linked = list[sign];
        if (linked != null) {
            linked.removeFirstOccurrence(key);
        }
    }

    public boolean contains(int key) {
        int sign = key % mod;
        LinkedList<Integer> linked = list[sign];
        return linked != null && linked.stream().anyMatch(x -> x == key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */