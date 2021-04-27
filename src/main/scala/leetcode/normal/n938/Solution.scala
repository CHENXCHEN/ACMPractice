package leetcode.normal.n938

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/range-sum-of-bst/
  * 938. 二叉搜索树的范围和
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    def isRange(value: Int): Boolean =
      low <= value && value <= high

    def calSum(treeNode: TreeNode): Int = {
      if (treeNode == null) return 0
      val now = if (isRange(treeNode.value)) treeNode.value else 0
      val left = if (treeNode.value >= low) calSum(treeNode.left) else 0
      val right = if (treeNode.value <= high) calSum(treeNode.right) else 0
      now + left + right
    }

    calSum(root)
  }
}