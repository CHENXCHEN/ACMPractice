package leetcode.normal.n108

/**
  * 将有序数组转换为二叉搜索树(https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)
  */
object Solution {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def generateTree(l: Int, r: Int, mid: Int, nums: Array[Int]): TreeNode = {
    if (l <= mid && mid <= r) {
      val treeNode = new TreeNode(nums(mid))
      treeNode.left = generateTree(l, mid - 1, (mid - 1 + l) >> 1, nums)
      treeNode.right = generateTree(mid + 1, r, (mid + 1 + r) >> 1, nums)
      treeNode
    } else null
  }

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    generateTree(0, nums.length - 1, (nums.length - 1) >> 1, nums)
  }
}
