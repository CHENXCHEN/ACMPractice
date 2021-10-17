package leetcode.normal.n230

import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
  * 230. 二叉搜索树中第K小的元素
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    val stack = new mutable.Stack[TreeNode]()
    var head = root
    var tk = k
    var ans = -1
    while ((head != null || stack.nonEmpty) && ans == -1) {
      while (head != null) {
        stack.push(head)
        head = head.left
      }
      head = stack.pop()
      tk -= 1
      if (tk == 0) {
        ans = head.value
      }
      head = head.right
    }
    ans
  }
}