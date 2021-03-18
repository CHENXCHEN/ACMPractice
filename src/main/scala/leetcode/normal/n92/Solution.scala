package leetcode.normal.n92

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/**
  * https://leetcode-cn.com/problems/reverse-linked-list-ii/
  * 92. 反转链表 II
  */
object Solution {
  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    var cnt = 0
    var isOver = false
    var root = head
    var leftLeftNode: ListNode = null
    var leftNode: ListNode = root
    var rightNode: ListNode = null
    while (root != null && !isOver) {
      cnt += 1
      val tmpNext = root.next
      if (cnt == left - 1) {
        leftLeftNode = root
      }
      if (cnt >= left && cnt <= right) {
        if (left == cnt) {
          leftNode = root
          rightNode = root
        } else {
          root.next = leftNode
          leftNode = root
          if (right == cnt) {
            rightNode.next = tmpNext
            if (leftLeftNode != null) leftLeftNode.next = leftNode
          }
        }
      } else if (cnt > right) isOver = true
      root = tmpNext
    }
    if (leftLeftNode == null) leftNode
    else head
  }
}
