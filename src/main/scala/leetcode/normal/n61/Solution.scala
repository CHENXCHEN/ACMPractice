package leetcode.normal.n61

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/rotate-list/
  * 61. 旋转链表
  */
object Solution {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null) return head
    var tot = 1
    var cur = head
    while (cur.next != null) {
      tot += 1
      cur = cur.next
    }
    cur.next = head
    var rotate = tot - k % tot
    if (rotate == tot) return head
    cur = head
    while (rotate > 0) {
      rotate -= 1
      cur = cur.next
    }
    val tmp = cur.next
    cur.next = null
    tmp
  }
}
