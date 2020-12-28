package leetcode.normal.n108

/**
  * 将有序数组转换为二叉搜索树(https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
  */
object Solution3 {

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

    var stack = List.empty[StackNode]
    val root = getTreeNode(0, nums.length - 1)
    stack = StackNode(root, 0, nums.length - 1) :: stack
    while (stack.nonEmpty) {
      val head = stack.head
      stack = stack.tail
      head match {
        case StackNode(cur, l, r) => val mid = (l + r) >> 1
          cur.left = getTreeNode(l, mid - 1)
          cur.right = getTreeNode(mid + 1, r)
          if (cur.left != null) stack = StackNode(cur.left, l, mid - 1) :: stack
          if (cur.right != null) stack = StackNode(cur.right, mid + 1, r) :: stack
      }
    }
    root
  }
}
