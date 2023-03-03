package leetcode.normal.j146;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lru-cache/?envType=study-plan&id=zijie&plan=7d_zijie&plan_progress=fuhc5v1">146. LRU 缓存</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class LRUCache2 {
    static class Node {
        Node next, pre;
        int key, val;

        Node(int _key, int _val) {
            this(_key, _val, null, null);
        }

        Node(int _key, int _val, Node _pre, Node _next) {
            key = _key;
            val = _val;
            next = _next;
            pre = _pre;
        }
    }

    int capacity, tot;
    Node vHead, vTail;
    Map<Integer, Node> tMap = new HashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        vHead = new Node(0, 0);
        vTail = new Node(0, 0);
        vHead.next = vTail;
        vTail.pre = vHead;
        tot = 0;
    }

    public int get(int key) {
        Node cur = tMap.get(key);
        if (cur != null) {
            removeNode(cur);
            addToHead(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node cur = tMap.get(key);
        if (cur != null) {
            removeNode(cur);
            addToHead(new Node(key, value));
        } else {
            if (tot >= capacity) removeNode(vTail.pre);
            addToHead(new Node(key, value));
        }
    }

    void removeNode(Node cur) {
        if (cur != null) {
            tMap.remove(cur.key);
            Node pre = cur.pre;
            Node next = cur.next;
            if (pre != null) pre.next = next;
            if (next != null) next.pre = pre;
            --tot;
        }
    }

    void addToHead(Node cur) {
        Node headNext = vHead.next;
        vHead.next = cur;
        cur.pre = vHead;
        cur.next = headNext;
        headNext.pre = cur;
        tMap.put(cur.key, cur);
        ++tot;
    }
}