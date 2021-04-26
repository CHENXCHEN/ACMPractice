package leetcode.normal.n897

case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/increasing-order-search-tree/
  * 897. 递增顺序搜索树
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def increasingBST(root: TreeNode): TreeNode = {
    var nRoot: TreeNode = null
    var curTreeNode: TreeNode = null

    def trans(treeNode: TreeNode): Unit = {
      if (treeNode == null) return
      trans(treeNode.left)
      if (nRoot == null) {
        nRoot = new TreeNode(treeNode.value)
        curTreeNode = nRoot
      } else {
        curTreeNode.right = new TreeNode(treeNode.value)
        curTreeNode = curTreeNode.right
      }
      trans(treeNode.right)
    }

    trans(root)
    nRoot
  }
}
