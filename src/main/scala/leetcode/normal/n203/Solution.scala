package leetcode.normal.n203

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/remove-linked-list-elements/
  * 203. 移除链表元素
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def removeElements(head: ListNode, vv: Int): ListNode = {
    val root = new ListNode(-1, head)
    var cur = root
    while (cur != null) {
      while (cur.next != null && cur.next.x == vv) {
        cur.next = cur.next.next
      }
      cur = cur.next
    }
    root.next
  }
}