package leetcode.normal.n108

import scala.collection.mutable

/**
  * 将有序数组转换为二叉搜索树(https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
  */
object Solution2 {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  case class StackNode(cur: TreeNode, l: Int, r: Int)

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.isEmpty) return null
    def getTreeNode(l: Int, r: Int): TreeNode = {
      val mid = (l + r) >> 1
      if (l <= mid && mid <= r) new TreeNode(nums(mid))
      else null
    }

    val stack = mutable.Stack[StackNode]()
    val root = getTreeNode(0, nums.length - 1)
    stack.push(StackNode(root, 0, nums.length - 1))
    while (stack.nonEmpty) {
      stack.pop() match {
        case StackNode(cur, l, r) => val mid = (l + r) >> 1
          cur.left = getTreeNode(l, mid - 1)
          cur.right = getTreeNode(mid + 1, r)
          if (cur.left != null) stack.push(StackNode(cur.left, l, mid - 1))
          if (cur.right != null) stack.push(StackNode(cur.right, mid + 1, r))
      }
    }
    root
  }
}
