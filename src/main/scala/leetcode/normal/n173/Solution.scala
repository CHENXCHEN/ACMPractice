package leetcode.normal.n173

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/binary-search-tree-iterator/
  * 173. 二叉搜索树迭代器
  */
object Solution {
  def main(args: Array[String]): Unit = {
    val iterator = new BSTIterator(TreeNode(7, TreeNode(3), TreeNode(15)))
    println(iterator.next())
    println(iterator.next())
  }
}

case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

class BSTIterator(_root: TreeNode) {
  // 0 -> 还未处理
  // 1 -> 正在处理左节点
  val q = mutable.Stack[(TreeNode, Int)]()
  if (_root != null) {
    q.push((_root, 0))
  }

  def next(): Int = {
    var ans: Option[Int] = Option.empty
    while (ans.isEmpty) {
      val (cur, ff) = q.pop()
      if (ff == 0) {
        if (cur.left != null) {
          q.push((cur, 1))
          q.push((cur.left, 0))
        } else {
          ans = Option(cur.value)
          if (cur.right != null) q.push((cur.right, 0))
        }
      } else if (ff == 1) {
        ans = Option(cur.value)
        if (cur.right != null) q.push((cur.right, 0))
      }
    }
    ans.get
  }

  def hasNext(): Boolean = {
    q.nonEmpty
  }
}