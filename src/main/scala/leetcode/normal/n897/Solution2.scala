package leetcode.normal.n897


/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/increasing-order-search-tree/
  * 897. 递增顺序搜索树
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution2 {
  def increasingBST(root: TreeNode): TreeNode = {
    var nRoot: TreeNode = null
    var curTreeNode: TreeNode = null

    def trans(treeNode: TreeNode): Unit = {
      if (treeNode == null) return
      trans(treeNode.left)
      if (nRoot == null) {
        nRoot = treeNode
        curTreeNode = nRoot
      } else {
        curTreeNode.right = treeNode
        treeNode.left = null
        curTreeNode = treeNode
      }
      trans(treeNode.right)
    }

    trans(root)
    nRoot
  }
}
