package leetcode.normal.n1600

import scala.collection.mutable

/**
  * Created by CHENXCHEN
  * https://leetcode-cn.com/problems/throne-inheritance/
  * 1600. 皇位继承顺序
  *
  * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
  */
class ThroneInheritance(_kingName: String) {

  val dSet = mutable.Set.empty[String]

  val nameTreeNode = mutable.Map.empty[String, TreeNode]

  case class TreeNode(name: String, var child: Seq[TreeNode] = Seq.empty)

  getTreeNodeByName(_kingName)

  def getTreeNodeByName(name: String): TreeNode = {
    if (!nameTreeNode.contains(name)) {
      nameTreeNode.put(name, TreeNode(name))
    }
    nameTreeNode(name)
  }

  def birth(parentName: String, childName: String): Unit = {
    val parentTreeNode = getTreeNodeByName(parentName)
    parentTreeNode.child :+= getTreeNodeByName(childName)
  }

  def death(name: String): Unit = {
    dSet.add(name)
  }

  def traverTreeNode(treeNode: TreeNode): Vector[String] = {
    var v = Vector.empty[String]
    if (!dSet.contains(treeNode.name)) {
      v :+= treeNode.name
    }
    treeNode.child.foreach(child => v ++= traverTreeNode(child))
    v
  }

  def getInheritanceOrder(): List[String] = {
    traverTreeNode(getTreeNodeByName(_kingName)).toList
  }

}

/**
  * Your ThroneInheritance object will be instantiated and called as such:
  * var obj = new ThroneInheritance(kingName)
  * obj.birth(parentName,childName)
  * obj.death(name)
  * var param_3 = obj.getInheritanceOrder()
  */

object Solution {

}

