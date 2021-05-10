package leetcode.normal.n872

import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/leaf-similar-trees/
  * 872. 叶子相似的树
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
object Solution {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    val seq1 = mutable.ArrayBuffer[Int]()
    val seq2 = mutable.ArrayBuffer[Int]()

    def dfs(treeNode: TreeNode, seq: mutable.ArrayBuffer[Int]): Unit = {
      if (treeNode != null) {
        if (treeNode.left == null && treeNode.right == null) {
          seq += treeNode.value
        }
        dfs(treeNode.left, seq)
        dfs(treeNode.right, seq)
      }
    }

    dfs(root1, seq1)
    dfs(root2, seq2)
    seq1 == seq2
  }
}