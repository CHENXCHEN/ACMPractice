package leetcode.normal.n783

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
  * 783. 二叉搜索树节点最小距离
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def minDiffInBST(root: TreeNode): Int = {
    var minNum =
      if (root.left != null) root.value - root.left.value
      else root.right.value - root.value
    var lastNum = Option.empty[Int]

    def dfs(rt: TreeNode): Unit = {
      if (rt.left != null) {
        dfs(rt.left)
      }

      if (lastNum.isEmpty) lastNum = Some(rt.value)
      else {
        minNum = minNum min (rt.value - lastNum.get)
        lastNum = Some(rt.value)
      }

      if (rt.right != null) {
        dfs(rt.right)
      }
    }

    dfs(root)
    minNum
  }
}
