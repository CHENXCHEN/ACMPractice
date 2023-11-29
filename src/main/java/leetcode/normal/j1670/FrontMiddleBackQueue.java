package leetcode.normal.j1670;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-front-middle-back-queue/description/">1670. 设计前中后队列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class FrontMiddleBackQueue {
    static class ListNode {
        ListNode pre, next;
        int val;

        ListNode(int _val) {
            val = _val;
        }

        ListNode(int _val, ListNode _pre, ListNode _next) {
            val = _val;
            pre = _pre;
            next = _next;
        }
    }

    ListNode root, left, mid, right;
    int size;

    boolean isOdd() {
        return (size & 1) == 1;
    }

    boolean isEven() {
        return (size & 1) == 0;
    }

    public FrontMiddleBackQueue() {
        root = new ListNode(0);
        size = 0;
    }

    public void pushFront(int val) {
        ++size;
        ListNode cur = new ListNode(val, root, root.next);
        addAfter(root, cur);
        left = root.next;
        if (size == 1) {
            right = mid = left;
        } else {
            if (isOdd()) {
                mid = mid.pre;
            }
        }
//        System.out.println("pushFront mid: " + mid.val + " cur: " + val + " size: " + size);
    }

    public void pushMiddle(int val) {
        if (size == 0) {
            pushFront(val);
            return;
        }
        ++size;
        ListNode cur = new ListNode(val, mid.pre, mid);
        addAfter(mid.pre, cur);
        if (isOdd()) {
            mid = mid.pre;
        }
        left = root.next;
//        System.out.println("pushMid mid: " + mid.val + " cur: " + val + " size: " + size);
    }

    public void pushBack(int val) {
        if (size == 0) {
            pushFront(val);
            return;
        }
        ++size;
        ListNode cur = new ListNode(val, right, null);
        addAfter(right, cur);
        right = cur;
        if (isEven()) {
            mid = mid.next;
        }
//        System.out.println("pushBack mid: " + mid.val + " cur: " + val + " size: " + size);
    }

    void addAfter(ListNode pre, ListNode now) {
        if (pre.next != null)
            pre.next.pre = now;
        pre.next = now;
    }

    public int popFront() {
        if (size == 0) return -1;
        --size;
        int ans = left.val;
        removeNode(left);
        left = root.next;
        if (left == null) {
            mid = right = null;
        } else {
            if (isEven()) {
                mid = mid.next;
            }
        }
        return ans;
    }

    public int popMiddle() {
        if (size == 0) return -1;
        int ans;
        if (isOdd()) {
            ans = mid.val;
            removeNode(mid);
        } else {
            ans = mid.pre.val;
            removeNode(mid.pre);
        }
        --size;
        left = root.next;
        if (left == null) {
            mid = right = null;
        } else {
            if (isEven()) {
                mid = mid.next;
            }
        }
        return ans;
    }

    public int popBack() {
        if (size == 0) return -1;
        --size;
        int ans = right.val;
        removeNode(right);
        left = root.next;
        if (left == null) {
            mid = right = null;
        } else {
            if (isOdd()) {
                mid = mid.pre;
            }
            right = right.pre;
        }
        return ans;
    }

    void removeNode(ListNode now) {
        now.pre.next = now.next;
        if (now.next != null)
            now.next.pre = now.pre;
    }
}