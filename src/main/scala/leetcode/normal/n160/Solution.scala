package leetcode.normal.n160

import scala.collection.mutable

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
  * 160. 相交链表
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    val lenA = getListNodeLen(headA)
    val lenB = getListNodeLen(headB)
    var rHeadA = if (lenA > lenB) subListNode(headA, lenA - lenB) else headA
    var rHeadB = if (lenB > lenA) subListNode(headB, lenB - lenA) else headB
    while (rHeadA != rHeadB) {
      rHeadA = rHeadA.next
      rHeadB = rHeadB.next
    }
    rHeadA
  }

  def getListNodeLen(head: ListNode): Int = {
    var len = 0
    var tmpNode = head
    while (tmpNode != null) {
      len += 1
      tmpNode = tmpNode.next
    }
    len
  }

  def subListNode(head: ListNode, skipLen: Int): ListNode = {
    var tmpNode = head
    var len = skipLen
    while (tmpNode != null && len > 0) {
      len -= 1
      tmpNode = tmpNode.next
    }
    tmpNode
  }
}
