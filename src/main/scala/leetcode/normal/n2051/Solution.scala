package leetcode.normal.n2051

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
  * 剑指 Offer 22. 链表中倒数第k个节点
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def getKthFromEnd(head: ListNode, k: Int): ListNode = {
    var fast = head
    var slow = head
    // 走过 k 步后，fast 的长度只剩下 n-k
    for (_ <- 0 until k) {
      fast = fast.next
    }
    // 走 n-k 步，slow 就只剩下 k 个
    while (fast != null) {
      slow = slow.next
      fast = fast.next
    }
    slow
  }
}