package leetcode.normal.j707;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-linked-list/">707. 设计链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class MyLinkedList {
    class LinkNode {
        int vv;
        LinkNode next, pre;

        LinkNode(int _v, LinkNode _next, LinkNode _pre) {
            vv = _v;
            next = _next;
            pre = _pre;
        }
    }

    int len = 0;
    LinkNode last, first;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index >= len) return -1;
        LinkNode ans = getIndexNode(index);
        return ans.vv;
    }

    public void addAtHead(int val) {
        LinkNode cur = new LinkNode(val, first, null);
        if (first != null) first.pre = cur;
        first = cur;
        if (len == 0) last = cur;
        ++len;
    }

    public void addAtTail(int val) {
        LinkNode cur = new LinkNode(val, null, last);
        if (last != null) last.next = cur;
        last = cur;
        if (len == 0) first = cur;
        ++len;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        } else if (index == len) {
            addAtTail(val);
            return;
        } else if (index > len) return;
        LinkNode idx = getIndexNode(index);
        LinkNode cur = new LinkNode(val, idx, idx.pre);
        LinkNode pre = idx.pre;
        pre.next = cur;
        idx.pre = cur;
        ++len;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            first = first.next;
            if (first != null) first.pre = null;
            --len;
            if (len == 0) last = null;
            return;
        } else if (index == len - 1) {
            last = last.pre;
            if (last != null) last.next = null;
            --len;
            if (len == 0) first = null;
            return;
        } else if (index >= len || index < 0) return;
        LinkNode idx = getIndexNode(index);
        LinkNode next = idx.next, pre = idx.pre;
        pre.next = next;
        next.pre = pre;
        --len;
    }

    private LinkNode getIndexNode(int index) {
        LinkNode ans = first;
        while (index-- > 0) ans = ans.next;
        return ans;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */