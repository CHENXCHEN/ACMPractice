package leetcode.normal.j1993;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/operations-on-tree/description/">1993. 树上的操作</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class LockingTree {

    int[] lockMark, parent;
    int n;
    ArrayList<Integer>[] sons;

    public LockingTree(int[] parent) {
        n = parent.length;
        this.parent = parent;
        this.lockMark = new int[n];
        Arrays.fill(lockMark, -1);
        sons = new ArrayList[n];
        for (int i = 0; i < n; i++) sons[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            sons[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (lockMark[num] == -1) {
            lockMark[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lockMark[num] == user) {
            lockMark[num] = -1;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (!hasFatherLock(num) && hasSonLock(num, num)) {
            unLockSons(num, num);
            lockMark[num] = user;
            return true;
        }
        return false;
    }

    boolean hasFatherLock(int cur) {
        while (cur != -1) {
            if (lockMark[cur] != -1) return true;
            cur = parent[cur];
        }
        return false;
    }

    boolean hasSonLock(int cur, int parent) {
        boolean res = false;
        if (cur != parent && lockMark[cur] != -1) return true;
        for (Integer to : sons[cur]) {
            res |= hasSonLock(to, cur);
            if (res) break;
        }
        return res;
    }

    void unLockSons(int cur, int parent) {
        if (cur != parent) lockMark[cur] = -1;
        for (Integer to : sons[cur]) {
            unLockSons(to, cur);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */