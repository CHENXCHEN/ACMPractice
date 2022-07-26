package leetcode.normal.j1206;

import java.util.Arrays;
import java.util.Random;

class Skiplist {

    int levelCount = 0, maxLevelCount = 16;
    double skipRate = 0.5;


    Random r = new Random();

    Node head = new Node(-1, maxLevelCount);

    int randomLevel() {
        int level = 1;
        while ((r.nextInt(2) & 1) < 1 && level < maxLevelCount) level++;
        return level;
    }

    public Skiplist() {

    }

    public boolean search(int target) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < target) {
                p = p.next[i];
            }
        }
        p = p.next[0];
        return p != null && p.key == target;
    }

    public void add(int num) {
        Node[] update = new Node[maxLevelCount];
        Node p = head;
        Arrays.fill(update, head);
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < num) {
                p = p.next[i];
            }
            update[i] = p;
        }
        int curLevel = randomLevel();
        if (curLevel > levelCount) levelCount = curLevel;
        Node now = new Node(num, curLevel);
        for (int i = 0; i < curLevel; i++) {
            now.next[i] = update[i].next[i];
            update[i].next[i] = now;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[maxLevelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].key < num) {
                p = p.next[i];
            }
            update[i] = p;
        }
        p = p.next[0];
        if (p == null || p.key != num) return false;
        for (int i = 0; i < levelCount; i++) {
            if (update[i].next[i] != p) {
                break;
            }
            update[i].next[i] = p.next[i];
        }
        while (levelCount > 1 && head.next[levelCount - 1] == null) levelCount--;
        return true;
    }
}

class Node {
    Node[] next;
    int key;

    Node(int _key, int _maxLevel) {
        key = _key;
        next = new Node[_maxLevel];
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */